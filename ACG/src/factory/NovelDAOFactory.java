package factory;

import dao.NovelDAO;
import daoImpl.novelDAOImpl;

public class NovelDAOFactory {
	public static NovelDAO getNovelDAOInstance(){
		return  new novelDAOImpl();
	}
	

}
