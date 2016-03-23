<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<title>Responsive Admin Layout</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Responsive Admin Layout">
<meta name="robots" content="index,follow" />
<meta name="keywords" content="responsive, responsive web, list, lists, media, html, css, html5, css3, inline, drop down, menu, navbar" />
<!-- ===== CSS START ==== -->
<link href="../_assets/css/decorator.css" rel="stylesheet">
<link href="../_assets/css/icons-ttf.css" rel="stylesheet">
<link href="../_assets/css/icons-decorator.css" rel="stylesheet">
<link href="css/theme.css" rel="stylesheet">
<!-- ===== CSS END ==== -->
</head>
<body class="fluid">
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-32319292-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

    <!-- Header / Menu Start -->
    
    <div class="fixed-header">
        
        <div class="width">
            
            <!-- Top horizontal navbar start -->

            <div class="navbar top-bar">

                <a href="#" class="brand">Brand</a>

                <ul class="left">
                    <li class="divider"></li>
                    <li><a href="#">Left 1</a></li>
                    <li class="divider"></li>
                    <li><a class="active" href="#">Left 2</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Left 3</a></li>
                    <li class="divider"></li>
                </ul>

                <!-- search form 1 start -->
                <form class="search-form">
                    <input type="text" class="input-left" placeholder="Search anything..">
                    <button type="submit" class="button button-right">Search</button>
                </form>
                <!-- search form 1 end -->
                
                <ul class="right dropdown-bottom">
                    <li>
                        <a href="#">Settings <span class="dart-bottom"></span></a>
                        <ul class="child white d-right">
                            <li><a href="#">First</a></li>
                            <li><a href="#">Second</a></li>
                            <li><a href="#">Third</a></li>
                            <li><a href="#">Fourth</a></li>
                        </ul>
                    </li>
                    <li class="divider"></li>
                </ul>
                
            </div>

            <!-- Top horizontal navbar end -->
            
        </div>
        
    </div>
    
    <!-- Header / Menu End -->
    
    <!-- Wrapper Start -->
    <div class="wrapper width clearfix">
        
        <div class="sidebar"><!-- Sidebar Start -->
            
            <ul class="menu"><!-- Menu Start -->
                
                <li class="first active">
                    <a href="#"><span class="dcon dcon-pen-streamline-2"></span><strong>Posts</strong></a>
                </li>
                <li>
                    <a href="#"><span class="dcon dcon-man-people-streamline-user"></span><strong>Users</strong></a>
                </li>
                <li>
                    <a href="#"><span class="dcon dcon-computer-imac"></span><strong>Media</strong></a>
                </li>
                <li>
                    <a href="#"><span class="dcon dcon-photo-pictures-streamline"></span><strong>Categories</strong></a>
                </li>
                <li>
                    <a href="#"><span class="dcon dcon-bubble-comment-streamline-talk"></span><strong>Comments</strong></a>
                </li>
                <li>
                    <a href="#"><span class="dcon dcon-design-pencil-rule-streamline"></span><strong>Appearance</strong></a>
                </li>
                <li>
                    <a href="#"><span class="dcon dcon-settings-streamline-1"></span><strong>Settings</strong></a>
                </li>
            </ul><!-- Menu End -->
            
        </div><!-- Sidebar End -->
        
        <div class="table-wrapper"><!-- Table Wrapper Start -->
        
        <div class="inner"><!-- Table Inner Start -->
            
            <!-- Stripped table start -->

            <table class="table striped-table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Post Title</th>
                        <th>Created</th>
                        <th>Type</th>
                        <th>Created by</th>
                        <th class="center-th">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>8</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>9</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>10</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>11</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>12</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>13</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>14</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>15</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>16</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>17</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>18</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>19</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>20</td>
                        <td><a href="#">Decorator - Front End Framework</a></td>
                        <td>24-12-2014</td>
                        <td>Blog Post</td>
                        <td><a href="#">Alan Museljic</a></td>
                        <td class="table-actions center-td">
                            <div class="dc_tip_wrap"><a href="#" title="edit" data-placement="top"><i class="si_pencil"></i></a></div>
                            <div class="dc_tip_wrap"><a href="#" title="delete" data-placement="top"><i class="si_trash"></i></a></div>
                        </td>
                    </tr>
                </tbody>
            </table>

            <!-- Stripped table end -->

            <!-- Table Pagination Start -->
            <div class="pagination-wrapper">
                <ul class="pagination">
                    <li class="first"><a href="#">«</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">...</a></li>
                    <li><a href="#">»</a></li>
                </ul>
            </div>
            <!-- Table Pagination End -->			
        
        </div><!-- Table Inner End -->
    </div><!-- Table Wrapper End -->
        
    </div>
    <!-- Wrapper End -->

<!-- ==================
    JAVASCRIPT START 
======================= -->
<script src="../_assets/js/jquery.js"></script>
<script src="../_assets/js/decorator/dc.menu.js"></script>
<script src="../_assets/js/decorator/dc.tip.js"></script>
<!-- ==================
     JAVASCRIPT END
======================= -->

<script type="text/javascript">
    
   $(document).ready(function(){
       
        // responsive menu
        $('.navbar').dcMenu();
        
        //table tooltips
        $(".table-actions a").dcTip();

   });


</script>
</body>
</html>

</body>
</html>