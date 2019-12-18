package com.project.dao;

import java.util.List;

import com.project.vo.CatVO;

public interface CatDAO {

	void insertCat(CatVO c);

	int getListCount(CatVO c);

	List<CatVO> getCatList(CatVO c);

	CatVO getCatCont(int cat_no);

	void editCat(CatVO c);

	void delCat(int cat_no);

	
	//고양이(먼치킨)
	int getListCount_mun(CatVO c_mun);

	List<CatVO> getCatList_mun(CatVO c_mun);

}
