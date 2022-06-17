package com.revature.oop.doas;
import java.io.Serializable;

import com.revature.oop.models.Task;

public interface TaskDAO extends Serializable, Cloneable {

	public abstract Task getTaskById(int id);
	Task addTask(Task newTask);
	default boolean deleteTask(int id) {
		return true;
	}
	
}
