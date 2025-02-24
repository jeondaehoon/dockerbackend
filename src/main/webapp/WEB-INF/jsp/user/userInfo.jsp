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
    <link rel="stylesheet" href="assets/vendors/bootstrap-icons/bootstrap-icons.css">
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
                        <a href="/capmerX_dashboard#" class='sidebar-link'>
                            <i class="bi bi-border-all"></i>
                            <span>데시보드</span>
                        </a>
                    </li>

                    <li class="sidebar-item has-sub">
                        <a href="/capmerX_adminadd" class='sidebar-link'>
                            <i class="bi bi-person-workspace"></i>
                            <span>사용자 관리</span>
                        </a>
                        <ul class="submenu ">
                            <li class="submenu-item">
                                <a href="/capmerX_adminadd">계정 생성/관리</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="/capmerX_adminRoles">권한 설정</a>
                            </li>
                        </ul>
                    <li class="sidebar-item has-sub">
                        <a href="#" class='sidebar-link'>
                            <i class="bi bi-box-seam"></i>
                            <span>재고 관리</span>
                        </a>
                        <ul class="submenu ">
                            <li class="submenu-item ">
                                <a href="/capmerX_stockInfo">제품 관리</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="capmerX_stockLog">재고 추적</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="/capmerX_stockAlert">재고 알림</a>
                            </li>
                        </ul>
                    </li>

                    <li class="sidebar-item  has-sub">
                        <a href="#" class='sidebar-link'>
                            <i class="bi bi-basket3"></i>
                            <span>주문 관리</span>
                        </a>
                        <ul class="submenu ">
                            <li class="submenu-item ">
                                <a href="/capmerX_orderProcess">주문 처리</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="/capmerX_orderHistory">주문 조회</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="/capmerX_orderCancel">환불 처리</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item active has-sub">
                        <a href="#" class='sidebar-link'>
                            <i class="bi bi-person-bounding-box"></i>
                            <span>고객 관리</span>
                        </a>
                        <ul class="submenu ">
                            <li class="submenu-item ">
                                <a href="/capmerX_userInfo">고객 정보 관리</a>
                            </li>
                            <li class="submenu-item ">
                                <a href="#">고객 서비스</a>
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
        <h1 class="h1-title">고객 정보 관리</h1>
        <form id="searchform">
            <input type="hidden" id="currentPage" name="currentPage" value="1">
            <table style="width: 10%; border-spacing: 10px;">
                <tr>
                    <td><input type='text' id='userName' name='userName' placeholder="상품명을 입력하세요" class="form-control"></td>
                    <td><input type='button' onclick='searchlist()' value='검색' class="btn btn-dark"></td>
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
                                    <th scope="col" id="#">ID</th>
                                    <th scope="col" id="#">고객 이름</th>
                                    <th scope="col" id="#">이메일 주소</th>
                                    <th scope="col" id="#">전화번호</th>
                                    <th scope="col" id="#">회원등급</th>
                                    <th scope="col" id="#">가입일</th>
                                    <th scope="col" id="#">상태</th>
                                </tr>
                                </thead>
                                <tbody id="OrdTable">
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<script src="assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>

<script src="assets/vendors/apexcharts/apexcharts.js"></script>
<script src="assets/js/pages/dashboard.js"></script>

<script src="assets/js/main.js"></script>
<script>
</script>
</body>

</html>