package resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resource.dao.TbContentMapper;
import resource.entity.TbContent;
import resource.entity.TbContentExample;

import java.util.List;

/** @Author: Marcus @Date: 2019/6/27 14:48 @Version 1.0 */
@Service
public class TbContentService {
  @Autowired private TbContentMapper contentMapper;

  public List<TbContent> selectAll() {
    return contentMapper.selectByExample(new TbContentExample());
  }

  public TbContent getById(Long id) {
    return contentMapper.selectByPrimaryKey(id);
  }

  public int insert(TbContent tbContent) {
    return contentMapper.insert(tbContent);
  }

  public Integer update(TbContent tbContent) {
    return contentMapper.updateByPrimaryKey(tbContent);
  }

  public Integer delete(Long id) {
    return contentMapper.deleteByPrimaryKey(id);
  }
}
