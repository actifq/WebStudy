package com.movie.dao;

import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;

/*

��ȭ�м� ���α׷�
����Ʈ ��Ű�� 

web-inf - lib�� jsoup-1.8.3 ���̺귯�� �߰�

*/

public class MovieManager {

	public static void main(String[] arg) {
		MovieManager m = new MovieManager();
		m.movieAllData();
	}

	public List<MovieDTO> movieAllData() {

		List<MovieDTO> list = new ArrayList<MovieDTO>();
		try {
			// doc�� cgv �ҽ� �о�ͼ� ������
			Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			// System.out.println(doc);

			// cgv ���� �ҽ����� div.box_contents�� �ִ� title�� ������
			// id�����ö��� #���̰�, Ŭ���� �����ö��� �׳� ��
			
			
			/*
			 *       <div class="box-image" >
                        <strong class="rank">No.2</strong>	
                        <a href="/movies/detail-view/?midx=78746">
                            <span class="thumb-image">
                                <img src="http://img.cgv.co.kr/Movie/Thumbnail/Poster/000078/78746/78746_185.jpg" alt="�����Ǿ� ������" onerror="errorImage(this)"/>
                                <span class="ico-grade grade-all">��ü</span>
                            </span>
                            
                        </a>

			 * 
			 */
			Elements titleElem = doc.select("div.box-contents strong.title");
			Elements imageElem = doc.select("div.box-image a span.thumb-image img");
			Elements rankElem = doc.select("div.box-image strong.rank");
			Elements gradeElem = doc.select("div.box-image a span.thumb-image span");
			
			Elements percentElem = doc.select("div.box-contents div.score strong.percent span");
			Elements likeElem = doc.select("div.box-contents span.like span.count strong i");
			Elements starElem = doc.select("div.box-contents span.percent");
			Elements dayElem = doc.select("div.box-contents span.txt-info strong");
			
			for (int i = 0; i < percentElem.size(); i++) {
				
				Element telem = titleElem.get(i);
				Element pelem = percentElem.get(i);
				Element delem = dayElem.get(i);
				Element lelem = likeElem.get(i);
				Element selem = starElem.get(i);
				Element ielem = imageElem.get(i);
				
				// img �±ױ��� �����Ѵ����� img��  �Ӽ��� src���� ������
				String img=ielem.attr("src");
				Element relem = rankElem.get(i);
				Element gelem = gradeElem.get(i);
				
				// �׽�Ʈ ���
				/*System.out.println(
						telem.text() + " " + 
						pelem.text() + " " + 
						delem.text() + " " + 
						lelem.text() + " " + 
						selem.text() + " " +
						img + " " +
						relem.text() + " " +
						gelem.text()
						);*/
				
				//���� (���� �ڸ���)
				//�����Ǿ� 7.5% 2016.02.17 ���� 12,579 98% http://img.cgv.co.kr/Movie/Thumbnail/Poster/000078/78746/78746_185.jpg No.2 ��ü
				
				MovieDTO d=new MovieDTO();
				d.setNo(i+1);
				d.setTitle(telem.text());
				//�׷����� �׸��� ���� �������� %�� ����� ������ ������
				d.setReserve(Double.parseDouble(pelem.text().substring(0,pelem.text().lastIndexOf('%'))));
				d.setImage(img);
				//�׷��� �׸������� ,�� ����� �������� ��
				d.setLike(Integer.parseInt(lelem.text().replace(",","")));
				//�׷��� �׸������� �������� ���� ���ڸ� �׸��� �����ò�
				d.setRegdata(delem.text().substring(0, delem.text().indexOf("����")));
				d.setStar(Integer.parseInt(selem.text().substring(0, selem.text().lastIndexOf('%'))));
				// ��ũ�� �տ� �ִ� no. �� ����
				d.setRank(Integer.parseInt(relem.text().substring(3)));
				d.setGrade(gelem.text());
				
				list.add(d);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	public MovieDTO movieDetail(int no){
		MovieDTO d=new MovieDTO();
		List<MovieDTO> list=movieAllData();
		d=list.get(no-1);
		return d;
	}

	//���̹� ��ȭ �ܾ����
	public List<String> movieRank(){
		List<String> list=new ArrayList<String>();
		
		try{
			Document doc=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rmovie.nhn").get();
			Elements elems=doc.select("td.title div.tit3");
			for (int i=0;i<10;i++){
				Element elem=elems.get(i);
				list.add(elem.text());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
	
	public List<String> movieReserve(){
		List<String> list=new ArrayList<String>();
		
		try{
			Document doc=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rreserve.nhn").get();
			Elements elems=doc.select("td.title div.tit4");
			for (int i=0;i<10;i++){
				Element elem=elems.get(i);
				list.add(elem.text());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
	
	public List<String> movieBoxoffice(){
		List<String> list=new ArrayList<String>();
		
		try{
			Document doc=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rboxoffice.nhn").get();
			Elements elems=doc.select("td.title div.tit1");
			for (int i=0;i<10;i++){
				Element elem=elems.get(i);
				list.add(elem.text());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}




}



























