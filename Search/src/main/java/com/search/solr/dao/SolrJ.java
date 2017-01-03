package com.search.solr.dao;

/**
 * Created by Administrator on 2016/12/23.
 */

import com.search.solr.bean.Person;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 使用solrJ来调用solr的服务
 */
public class SolrJ {

    @Test
    public void addIndex()throws SolrServerException,IOException{
        String urlString = "http://localhost:8080/solr";

        SolrServer solr = new HttpSolrServer(urlString);

        //第一种添加方式...
        SolrInputDocument document=new SolrInputDocument();

        document.addField("id", "9527");

        document.addField("name", "武书静");

        document.addField("xxxxx_ss", "很有文艺范的一个名字");




        solr.add(document);

//		solr.addBeans(list);

        //	solr.addBean(article);

        solr.commit();
    }

    /**
     * 查询
     */
    @Test
    public void testFind() throws SolrServerException {
        String urlString = "http://localhost:8080/solr";

        SolrServer solr = new HttpSolrServer(urlString);

        //以后参数都是通过这个对象去构造
        SolrQuery solrParams = new SolrQuery();
        Person person = new Person();
        person.setId(1);
        person.setAuthor("刘通");
        solrParams.setQuery(person.toString());

        //开启高亮...
        solrParams.setHighlight(true);

        //高亮显示的格式...
//        solrParams.setHighlightSimplePre("<font color='red'>");
//        solrParams.setHighlightSimplePost("</font>");


        //我需要那几个字段进行高亮...

//        solrParams.setParam("hl.fl", "description");
        QueryResponse queryResponse = solr.query(solrParams);

        //返回所有的结果...
        SolrDocumentList documentList = queryResponse.getResults();

//返回高亮之后的结果..
        Map<String, Map<String, List<String>>> maplist = queryResponse.getHighlighting();


        for (SolrDocument solrDocument : documentList) {
            Object id = solrDocument.get("id");
//			Object name=solrDocument.get("name");
//			Object content=solrDocument.get("description");
//			System.out.println(id);
//			System.out.println(name);
//			System.out.println(content);
            Map<String, List<String>> fieldMap = maplist.get(id);
            List<String> stringlist = fieldMap.get("name");

            System.out.println(stringlist);

        }
    }
}
