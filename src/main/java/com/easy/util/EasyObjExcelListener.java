package com.easy.util;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.List;

public class EasyObjExcelListener<E> implements ReadListener<E> {

    public List<E> list=new ArrayList<>();

    /**
     * ��ȡ����ÿһ�����󶼻����invoke
     * @param data
     * @param analysisContext
     */
    @Override
    public void invoke(E data, AnalysisContext analysisContext) {
        
        //System.out.println(data);
        list.add(data);
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("----��ȡ���");
        //System.out.println(list);
    }

}