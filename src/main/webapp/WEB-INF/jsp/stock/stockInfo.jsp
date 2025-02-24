<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Camper_X</title>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Freight+Sans:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/main.css">

    <link rel="stylesheet" href="assets/vendors/iconly/bold.css">

    <link rel="stylesheet" href="assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" href="assets/css/app.css">
    <link rel="shortcut icon" href="assets/images/favicon.svg" type="image/x-icon">
</head>

<body>
<div id="app">
    <div id="sidebar" class="active">
        <div class="sidebar-wrapper active">
            <div class="sidebar-header">
                <div class="d-flex justify-content-between">
                    <div class="logo">
                        <a href="/capmerX_dashboard"><img src="assets/images/logo/CAMPERX LOGO.png" alt="Logo" srcset=""></a>
                    </div>
                    <div class="toggler">
                        <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                    </div>
                </div>
            </div>
            <div class="sidebar-menu">
                <ul class="menu">
                    <li class="sidebar-title">Menu</li>

                    <li class="sidebar-item">
                        <a href="/capmerX_dashboard" class='sidebar-link'>
                            <i class="bi bi-border-all"></i>
                            <span>데시보드</span>
                        </a>
                    </li>

                    <li class="sidebar-item has-sub">
                        <a href="#" class='sidebar-link'>
                            <i class="bi bi-person-workspace"></i>
                            <span>사용자 관리</span>
                        </a>
                        <ul class="submenu ">
                            <li class="submenu-item">
                                <a href="/camperX_adminadd">계정 생성/관리</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="/camperX_adminRoles">권한 설정</a>
                            </li>
                        </ul>
                    <li class="sidebar-item active has-sub">
                        <a href="#" class='sidebar-link'>
                            <i class="bi bi-box-seam"></i>
                            <span>재고 관리</span>
                        </a>
                        <ul class="submenu ">
                            <li class="submenu-item ">
                                <a href="/camperX_stockInfo">제품 관리</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="/camperX_stockLog">재고 추적</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="/camperX_stockAlert">재고 알림</a>
                            </li>
                        </ul>
                    </li>

                    <li class="sidebar-item has-sub">
                        <a href="#" class='sidebar-link'>
                            <i class="bi bi-basket3"></i>
                            <span>주문 관리</span>
                        </a>
                        <ul class="submenu ">
                            <li class="submenu-item ">
                                <a href="/camperX_orderProcess">주문 처리</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="camperX_orderHistory">주문 조회</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="camperX_orderCancel">환불 처리</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item  has-sub">
                        <a href="#" class='sidebar-link'>
                            <i class="bi bi-person-bounding-box"></i>
                            <span>고객 관리</span>
                        </a>
                        <ul class="submenu ">
                            <li class="submenu-item ">
                                <a href="camperX_userInfo">고객 정보 관리</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="camperX_userService">고객 서비스</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item  has-sub">
                        <a href="#" class='sidebar-link'>
                            <i class="bi bi-newspaper"></i>
                            <span>보고서 및 분석</span>
                        </a>
                        <ul class="submenu ">
                            <li class="submenu-item ">
                                <a href="#">판매</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="#">재고</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
        </div>
    </div>
</div>
<main id="main" class="main">
    <div class="pagetitle">
        <h1 class="h1-title">제품 관리</h1>
        <form id="searchform">
            <input type="hidden" id="currentPage" name="currentPage" value="1">
            <table style="width: 10%; border-spacing: 10px;">
                <tr>
                    <td><input type='text' id='userName' name='userName' placeholder="상품명을 입력하세요" class="form-control"></td>
                    <td><input type='button' onclick='StockSearchList()' value='검색' class="btn btn-dark"></td>
                    <td><input type='button' onclick='openModal()' value='추가' class="btn btn-dark"></td>
                    <td><input type='button' onclick='searchlist()' value='삭제' class="btn btn-dark"></td>

                </tr>
            </table>
        </form>
    </div>

    <section class="section">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <form id="update">
                            <table class="table" id="userinfo">
                                <thead>
                                <tr>
                                    <th scope="col"><input type="checkbox" id="selectAll" onclick="toggleSelectAll()"></th>
                                    <th scope="col" id="prdCode">SKU</th>
                                    <th scope="col" id="prdName">제품명</th>
                                    <th scope="col" id="catCode">카테고리</th>
                                    <th scope="col" id="price">가격</th>
                                    <th scope="col" id="prdStatus">상태</th>
                                </tr>
                                </thead>
                                <tbody id="StockListTable">
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="modal fade text-left" id="dark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel150" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header bg-dark white">
                <span class="modal-title" id="myModalLabel150">
                    상품 추가
                </span>
                    <button type="button" class="close"
                            data-bs-dismiss="modal" aria-label="Close">
                        <i data-feather="x"></i>
                    </button>
                </div>
                <!-- 모달 내용 시작 -->
                <div class="modal-body">
                        <form id="prdaddform" enctype="multipart/form-data">
                            <input type="hidden" id="catUplv" name="catUplv">
                            <input type="hidden" id="catLv" name="catLv">
                        <!-- 상품 이름 -->
                        <div class="mb-3">
                            <label for="prdName" class="form-label">상품명</label>
                            <input type="text" class="form-control" id="prdName" name="prdName" placeholder="상품명을 입력하세요" required>
                        </div>

                        <!-- SKU -->
                        <div class="mb-3">
                            <label for="prdCode" class="form-label">SKU (고유 상품 코드)</label>
                            <input type="text" class="form-control" id="prdCode" name="prdCode" placeholder="상품의 SKU를 입력하세요" required>
                        </div>

                        <!-- 가격 -->
                        <div class="mb-3">
                            <label for="price" class="form-label">가격</label>
                            <input type="number" class="form-control" id="price" name="price" placeholder="가격을 입력하세요" required>
                        </div>

                        <!-- 색상 -->
                        <div class="mb-3">
                            <label for="prdColor" class="form-label">색상</label>
                            <input type="text" class="form-control" id="prdColor" name="prdColor" placeholder="색상코드를 입력하세요" required>
                        </div>

                        <!-- 카테고리 -->
                        <div class="mb-3">
                            <label for="maincatcode" class="form-label">카테고리</label>
                            <select class="form-select" id="maincatcode" name="mainCode" onchange="catCodeSelect(this)" required>
                                <option value="" disabled selected>카테고리를 선택하세요</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="subcatcode" class="form-label">서브 카테고리</label>
                            <select class="form-select" id="subcatcode" name="subCode" required>
                                <option value="" disabled selected>서브 카테고리를 선택하세요</option>
                            </select>
                        </div>



                            <!-- 재고량 -->
                        <div class="mb-3">
                            <label for="prdQty" class="form-label">재고량</label>
                            <input type="number" class="form-control" id="prdQty" name="prdQty" placeholder="재고량을 입력하세요" required>
                        </div>

                        <!-- 설명 -->
                        <div class="mb-3">
                            <label for="prdDesc" class="form-label">상품 설명</label>
                            <textarea class="form-control" id="prdDesc" name="prdDesc" rows="3" placeholder="상품에 대한 설명을 입력하세요"></textarea>
                        </div>

                        <!-- 이미지 업로드 -->
                        <div class="mb-3">
                            <label for="prdImg" class="form-label">상품 이미지</label>
                            <input type="file" class="form-control" id="prdImg" name="prdImgFile" accept="image/*">
                        </div>

                        <!-- 안전 재고량 -->
                        <div class="mb-3">
                            <label for="safetyStock" class="form-label">안전 재고량</label>
                            <input type="number" class="form-control" id="safetyStock" name="safetyStock" placeholder="최소 안전 재고량을 설정하세요" required>
                        </div>

                    </form>
                </div>
                <!-- 모달 내용 끝 -->
                <div class="modal-footer">
                    <button type="button"
                            class="btn btn-light-secondary"
                            data-bs-dismiss="modal">
                        <i class="bx bx-x d-block d-sm-none"></i>
                        <span class="d-none d-sm-block">취소</span>
                    </button>
                    <button type="button" onclick="prdadd()" class="btn btn-dark ml-1" data-bs-dismiss="modal">
                        <i class="bx bx-check d-block d-sm-none"></i>
                        <span class="d-none d-sm-block">확인</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="/assets/js/jquery-3.7.1.min.js"></script>
<script src="/assets/js/common.js"></script>
<script src="assets/js/main.js"></script>
<script>
    function openModal() {
        var myModal = new bootstrap.Modal(document.getElementById('dark'));

        $('#catUplv').val("");
        $('#catLv').val(1);

        call_server(prdaddform, '/cat/search', setcatList);

        myModal.show();
    }

    var catelist = new Array();
    function setcatList(list) {
        catelist = list;
        $('#maincatcode').empty();
        for (var i = 0; i < list.length; i++) {
            if(list[i].catUplv===' ') {
                var str = "<option value='" + list[i].catCode + "'>" + list[i].catName + "</option>";
                $('#maincatcode').append(str);
            }
        }
    }

    function catCodeSelect(obj, lev){
        var cd = $(obj).val();
        var lv = "";
        for(var i=0;i<catelist.length;i++){
            if(catelist[i].catCode==cd){
                lv =  catelist[i].catLv;
                break;
            }
        }
        $('#subcatcode').empty();
        for(var i=0;i<catelist.length;i++){
            if(catelist[i].catUplv==lv){
                var str = "<option value='" + catelist[i].catCode + "'>" + catelist[i].catName + "</option>";
                $('#subcatcode').append(str);
            }
        }
    }

    function prdadd(){
        call_server(prdaddform, 'stock/prdadd', setprdAdd)
    }

    function setprdAdd(){
        alert("저장완료되었습니다.")
    }

    function StockSearchList() {
        call_server(searchform, 'stock/search', setStockList)
    }

    function setStockList(list){
        $('StockListTable tbody').empty();
        if(list.length === 0) {
            $('StockListTable').append('<tr><td colspan="8">검색된 상품이 없습니다.</td></tr>');
        } else {
            for (var i = 0; i < list.length; i++){
                var str = "<tr>";
                str += "<td><input type='checkbox' name='stockArry[" + i + "]' data-id='" + list[i].prdName + "' value='" + list[i].prdCode + "'></td>";
                str += "<td>" + list[i].prdCode + "</td>";
                str += "<td>" + list[i].prdName + "</td>";
                str += "<td>" + list[i].catCode + "</td>";
                str += "<td>" + addComma(list[i].price) + "</td>";
                str += "<td>" + list[i].prdStatus + "</td>";
                str += "</tr>";
                $('#StockListTable').append(str);
            }
        }
    }



</script>
</body>

</html>