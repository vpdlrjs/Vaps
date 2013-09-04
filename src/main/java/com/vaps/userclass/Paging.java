package com.vaps.userclass;

public class Paging {
	private int maxNum; 			// 전체 글의 숫자
	private int pageNum; 		// 현재 페이지 번호
	private int listCount; 			// 페이지당 나타낼 글의 갯수
	private int pageCount; 		// 페이지그룹당 페이지 갯수
	private String pageName; 	// 게시판의 종류

	public Paging(int maxNum, int pageNum, int listCount, int pageCount, String pageName) {
		this.maxNum = maxNum;
		this.pageNum = pageNum;
		this.listCount = listCount;
		this.pageCount = pageCount;
		this.pageName = pageName;
	}

	@SuppressWarnings("unused")
	public String makePageGroup() {
		// 전체 페이지 갯수
		int totalPage = (maxNum % listCount > 0) ? maxNum / listCount + 1 : maxNum / listCount;
		// 전체 페이지 그룹 갯수
		int totalGroup = (totalPage % pageCount > 0) ? totalPage / pageCount + 1 : totalPage / pageCount;
		// 현재 페이지가 속해 있는 그룹 번호
		int currentGroup = (pageNum % pageCount > 0) ? pageNum / pageCount + 1 : pageNum / pageCount;
		return makeHtml(currentGroup, totalPage, pageName);
	}

	private String makeHtml(int currentGroup, int totalPage, String pageName) {
		StringBuffer sb = new StringBuffer();
		int start = (currentGroup * pageCount) - (pageCount - 1);
		int end = (currentGroup * pageCount >= totalPage) ? totalPage : currentGroup * pageCount;

		if (start != 1) {
			sb.append("<a href="+pageName+"?pageNum=" + (start - 1) + ">");
			sb.append("[이전]");
			sb.append("</a>");
		}

		for (int i = start; i <= end; i++) {
			if (pageNum != i) {
				sb.append("<a href="+pageName+"?pageNum=" + i + ">");
				sb.append(" [ ");
				sb.append(i);
				sb.append(" ] ");
				sb.append("</a>");
			} else {
				sb.append("<font style='color:red;'>");
				sb.append(" [ ");
				sb.append(i);
				sb.append(" ] ");
				sb.append("</font>");
			}
		}
		if (end != totalPage) {
			sb.append("<a href="+pageName+"?pageNum=" + (end + 1) + ">");
			sb.append("[다음]");
			sb.append("</a>");
		}
		return sb.toString();
	}
}
