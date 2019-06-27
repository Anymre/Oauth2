package resource.controller;

import com.mysql.cj.protocol.x.Notice;
import org.mockito.internal.matchers.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import resource.entity.TbContent;
import resource.service.TbContentService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TbContentController {

  @Autowired private TbContentService tbContentService;

  /**
   * 获取全部资源
   *
   * @return
   */
  @GetMapping("/")
  public List<TbContent> selectAll() {
    return tbContentService.selectAll();
  }

  class Access {
    String access_token;
    String token_type;
    String expires_in;
    String scope;
  }

  @RequestMapping("/oauth2")
  public ModelAndView oauth(@RequestParam String code) {
    BaseOAuth2ProtectedResourceDetails baseOAuth2ProtectedResourceDetails =
        new BaseOAuth2ProtectedResourceDetails();
    baseOAuth2ProtectedResourceDetails.setClientId("client");
    baseOAuth2ProtectedResourceDetails.setClientSecret("123456");
    baseOAuth2ProtectedResourceDetails.setGrantType("authorization_code");
    AccessTokenRequest atr = new DefaultAccessTokenRequest();
    OAuth2RestTemplate restTemplate =
        new OAuth2RestTemplate(baseOAuth2ProtectedResourceDetails, new DefaultOAuth2ClientContext(atr));

    return new ModelAndView("redirect:/?code=");
  }

  /**
   * 获取资源详情
   *
   * @param id
   * @return
   */
  @GetMapping("/view/{id}")
  public TbContent getById(@PathVariable Long id) {
    return tbContentService.getById(id);
  }

  /**
   * 新增资源
   *
   * @param tbContent
   * @return
   */
  @PostMapping("/insert")
  public Integer insert(@RequestBody TbContent tbContent) {
    return tbContentService.insert(tbContent);
  }

  /**
   * 更新资源
   *
   * @param tbContent
   * @return
   */
  @PutMapping("/update")
  public Integer update(@RequestBody TbContent tbContent) {
    return tbContentService.update(tbContent);
  }

  /**
   * 删除资源
   *
   * @param id
   * @return
   */
  @DeleteMapping("/delete/{id}")
  public Integer delete(@PathVariable Long id) {
    return tbContentService.delete(id);
  }
}
