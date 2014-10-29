package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Evaluate;

public interface EvaluateDao {
	// 查看评论
	public List<Evaluate> checkEvaluate();

	// 删除评论
	public int deleteEvaluate(int id);

	// 提交评论
	public int addEvaluate(Evaluate evaluate);

	// 批量删除评论
	public int deleteBatchEvaluate(String ids);
	// 评论没有修改只有回复

}
