var defaultImgLoc          = "";
var defaultReqPagingFuncNm = "requestPage";
var defaultGridPageId      = "gridPaging";

var pagingBox = {};

pagingBox.checkNull = function (gridPagingId, currPage, pageCount, groupCount, totalCount, reqPagingFuncNm) {
    if(isNull(gridPagingId )) {gridPagingId  = defaultGridPageId;}
    
    if(isNull(currPage     )) {currPage      = 0;}
    if(isNull(pageCount    )) {pageCount     = 0;}
    if(isNull(groupCount   )) {groupCount    = 0;}
    if(isNull(totalCount   )) {totalCount    = 0;}
    if(isNull(reqPagingFuncNm)) {reqPagingFuncNm = defaultReqPagingFuncNm;}
}

pagingBox.setPage = function (gridPagingId, currPage, pageCount, groupCount, totalCount, reqPagingFuncNm, isDeleteBtn) {
    
    pagingBox.checkNull(gridPagingId, currPage, pageCount, groupCount, totalCount, reqPagingFuncNm);
    
    var page        = 0;
    
    var currGroup   = 0;
    var totalGroup  = 0;

    var startPage   = 0;
    var endPage     = 0;
    var totalPage   = 0;
    
    totalPage  = parseInt((totalCount - 1) / pageCount )  + 1;
    currGroup  = parseInt((currPage   - 1) / groupCount)  + 1;
    totalGroup = parseInt((totalPage  - 1) / groupCount)  + 1;
    
    startPage  = (currGroup  - 1) * groupCount + 1;
    endPage    = parseInt(parseInt(startPage) + parseInt(groupCount - 1));
    
    if( endPage > totalPage) {
        endPage = totalPage;
    }

    var gridPage = document.getElementById(gridPagingId);
    var inHtml = "<p class=\"list_nums\">총 <strong>" + totalCount + "</strong>건</p>";
    inHtml = inHtml + "<div class=\"paging\">";
    
    if( currGroup > 1 ) {
        page = startPage - groupCount;
        inHtml = inHtml + "<a href=\"#\" onclick=\"" + reqPagingFuncNm + "(" + 1 + "); return false;\" class=\"page first\" title=\"처음\">First</a>\n";
    }
    
    if ( currGroup > 1 ) {
        page = startPage - groupCount;
        inHtml = inHtml + "<a href=\"#\" onclick=\"" + reqPagingFuncNm + "(" + page + "); return false;\" class=\"page prev\" title=\"이전\">Previous</a>\n";
    }
    
    if ( totalCount > 0 ) {
        for (var i = startPage; i <= endPage; i++) {
            if (i == currPage) {
                inHtml = inHtml + "<a href=\"#\" class=\"current\" title=\""+ i + "\">" + i + "</a>\n";
            } else {
                inHtml = inHtml + "<a href=\"#\" title=\""+ i + "\" onclick=\"" + reqPagingFuncNm + "(" + i + "); return false;\">" + i + "</a>\n";
            }
        }
    }

    if ( currGroup < totalGroup ) {
        page   = (currGroup * groupCount) + 1;
        inHtml = inHtml + "<a href=\"#\" onclick=\"" + reqPagingFuncNm + "(" + page + "); return false;\" class=\"page next\" title=\"다음\">Next</a>\n";
    }

    if ( endPage < totalPage ) {
        page = (currGroup * groupCount) + 1;
        inHtml = inHtml + "<a href=\"#\" onclick=\"" + reqPagingFuncNm + "(" + totalPage + "); return false;\" class=\"page last\" title=\"마지막\">Last</a>\n";
    }

    inHtml = inHtml + "</div>\n";
    
    gridPage.innerHTML = inHtml;
};

