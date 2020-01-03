package com.project.dao;


import com.project.vo.NormalBoardVO;

import java.util.List;

public interface NormalServiceDAO {

    int insertBoard(NormalBoardVO nbv);

    int getListCount(NormalBoardVO nbv);

    List<NormalBoardVO> getUserBoardList(NormalBoardVO nbv);

    NormalBoardVO selectnormalboardcont(NormalBoardVO nbv);

    int normal_reply_ok(NormalBoardVO nbv);

    List<NormalBoardVO> getreplylist(NormalBoardVO nbv);

    void update_hit(NormalBoardVO nbv);
}