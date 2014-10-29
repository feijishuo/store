package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Messages;

public interface MessageDao {
	// 查看未回复留言
	public List<Messages> checkMessage(int state);

	// 回复留言
	public int AnswerMessage();
}
