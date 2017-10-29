package lection05.task03;

import java.io.IOException;

import lection04.task01.Group;

public interface GroupDAO {
	public void saveGroup(Group group) throws IOException;

	public Group loadGroup() throws IOException;
}
