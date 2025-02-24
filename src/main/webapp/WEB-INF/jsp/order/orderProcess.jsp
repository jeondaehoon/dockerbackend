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
                    <li class="sidebar-item has-sub">
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

                    <li class="sidebar-item active has-sub">
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
        <h1 class="h1-title">주문 처리</h1>
        <form id="searchform">
            <input type="hidden" id="currentPage" name="currentPage" value="1">
            <table style="width: 10%; border-spacing: 10px;">
                <tr>
                    <td><input type='text' id='userId' name='userId' placeholder="상품명을 입력하세요" class="form-control"></td>
                    <td><input type='button' onclick='orderListSearch()' value='검색' class="btn btn-dark"></td>
                    <td><input type='button' onclick='orderShipped()' value='상품준비중' class="btn btn-dark"></td>
                    <td><input type='button' onclick='orderDelivered()' value='배송완료' class="btn btn-dark"></td>
                </tr>
            </table>
        </form>
    </div>

    <section class="section">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <form id="orderListForm">
                            <table class="table" id="userinfo">
                                <thead>
                                <tr>
                                    <th scope="col"><input type="checkbox" id="selectAll" onclick="toggleSelectAll()"></th>
                                    <th scope="col" id="ordCode" name="ordCode">주문번호</th>
                                    <th scope="col" id="userName" name="userName">고객 이름</th>
                                    <th scope="col" id="userId" name="userId">고객 아이디</th>
                                    <th scope="col" id="prdName" name="prdName">상품명</th>
                                    <th scope="col" id="buyQty" name="buyQty">수량</th>
                                    <th scope="col" id="returnStatus" name="returnStatus">반품</th>
                                    <th scope="col" id="ordStatus" name="ordStatus">상품상태</th>
                                </tr>
                                </thead>
                                <tbody id="orderList">
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- 주문 상세 모달 -->
    <div class="modal fade text-left" id="orderDetailModal" tabindex="-1" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header bg-dark white">
                <span class="modal-title" id="orderModalLabel">
                    주문 상세 정보
                </span>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <i data-feather="x"></i>
                    </button>
                </div>
                <!-- 모달 내용 시작 -->
                <div class="modal-body">
                    <form id="orderDetailForm">
                        <!-- 주문 번호 (상세보기) -->
                        <div class="mb-3">
                            <label for="orderNumber" class="form-label">주문 번호</label>
                            <input type="text" class="form-control" id="orderNumber" placeholder="주문 번호" readonly>
                        </div>

                        <!-- 고객 이름 -->
                        <div class="mb-3">
                            <label for="customerName" class="form-label">고객 이름</label>
                            <input type="text" class="form-control" id="customerName" placeholder="고객 이름" readonly>
                        </div>

                        <!-- 주문 날짜 -->
                        <div class="mb-3">
                            <label for="orderDate" class="form-label">주문 날짜</label>
                            <input type="text" class="form-control" id="orderDate" placeholder="주문 날짜" readonly>
                        </div>

                        <!-- 상품명 -->
                        <div class="mb-3">
                            <label for="productName" class="form-label">상품명</label>
                            <input type="text" class="form-control" id="productName" placeholder="상품명" readonly>
                        </div>

                        <!-- 수량 -->
                        <div class="mb-3">
                            <label for="quantity" class="form-label">수량</label>
                            <input type="number" class="form-control" id="quantity" placeholder="수량" readonly>
                        </div>

                        <!-- 가격 -->
                        <div class="mb-3">
                            <label for="price" class="form-label">가격</label>
                            <input type="number" class="form-control" id="price" placeholder="가격" readonly>
                        </div>

                        <!-- 배송 상태 -->
                        <div class="mb-3">
                            <label for="deliveryStatus" class="form-label">배송 상태</label>
                            <select class="form-select" id="deliveryStatus" disabled>
                                <option value="대기 중">대기 중</option>
                                <option value="배송 준비 중">배송 준비 중</option>
                                <option value="배송 중">배송 중</option>
                                <option value="배송 완료">배송 완료</option>
                            </select>
                        </div>

                        <!-- 고객 요청 사항 -->
                        <div class="mb-3">
                            <label for="customerRequest" class="form-label">고객 요청 사항</label>
                            <textarea class="form-control" id="customerRequest" rows="3" placeholder="고객의 요청 사항을 입력하세요" readonly></textarea>
                        </div>

                    </form>
                </div>
                <!-- 모달 내용 끝 -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-light-secondary" data-bs-dismiss="modal">
                        <i class="bx bx-x d-block d-sm-none"></i>
                        <span class="d-none d-sm-block">취소</span>
                    </button>
                    <button type="button" class="btn btn-dark ml-1" id="confirmBtn" data-bs-dismiss="modal">
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
        var myModal = new bootstrap.Modal(document.getElementById('orderDetailModal'));
        myModal.show();
    }

    function orderListSearch(){
        call_server(searchform, 'order/search', setorderSearch)
    }

    function setorderSearch(list){
        console.log(list);
        $('#orderList').empty();
        if(list.length === 0) {
            $('#orderList').append('<tr><td colspan="8">검색된 고객이 없습니다.</td></tr>');
        } else {
            for (var i = 0; i < list.length; i++){
                var str = "<tr>";
                str += "<td><input type='checkbox' name='orderArry[" + i + "]' data-id='" + list[i].userId + "' value='" + list[i].ordCode + "'></td>";
                str += "<td>" + list[i].ordCode + "</td>";
                str += "<td>" + list[i].userName + "</td>";
                str += "<td>" + list[i].userId + "</td>";
                str += "<td>" + list[i].prdName + "</td>";
                str += "<td>" + list[i].buyQty + "</td>";
                str += "<td>" + list[i].returnStatus + "</td>";
                str += "<td>" + list[i].ordStatus + "</td>";
                str += "</tr>";
                $('#orderList').append(str);
            }
        }
    }


    function orderShipped(){
        call_server(orderListForm, 'order/Shipped', setShipped)
    }

    function setShipped(data){
        if(data){
            alert("변경이 완료 되었습니다.")
            orderListSearch();
        }else {
            alert("오류가 발생하였습니다.")
        }
    }

    function orderDelivered(){
        call_server(orderListForm, 'order/Delivered', setDelivered)
    }

    function setDelivered(data){
        if(data){
            alert("변경이 완료 되었습니다.")
            orderListSearch();
        }else {
            alert("오류가 발생하였습니다.")
        }
    }

    function toggleSelectAll() {
        var isChecked = $('#selectAll').prop('checked');
        $('input[name^="orderArry"]').prop('checked', isChecked);
    }

</script>
</body>

</html>