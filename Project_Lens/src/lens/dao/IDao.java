package lens.dao;

import java.util.List;

public interface IDao<T,K> {
	public void insert(T vo);
	public void delete(K primaryKey);
	public void update(T vo);
	public T select(K primaryKey);
	public List selectAll();
	public List<T> find();
}
