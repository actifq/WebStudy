<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">
	
	/*
			
	selector : ���尴ü, �±׸�, ID�� , Class ��    �о����!
			���尴ü	: $(document)
			�±׸� : $('�±׸�')  ex $('tr')  
			ID�� ($('#ID��'))
			Class�� ($('.class��'))
			
			$(document)
			
	*/
	
	$(function(){
		$('#sendBtn').click(function(){
			var name=$('#name').val();
			if(name.trim()==""){
				$('#name').focus();
				$('#name').val("");
				return;
			}
			var name=$('#subject').val();
			if(name.trim()==""){
				$('#subject').focus();
				$('#subject').val("");
				return;
			}
			var name=$('#content').val();
			if(name.trim()==""){
				$('#content').focus();
				$('#content').val("");
				return;
			}
			var name=$('#pwd').val();
			if(name.trim()==""){
				$('#pwd').focus();
				$('#pwd').val("");
				return;
			}	
			
			$('#frm').submit();
		});
	});
</script>
</head>



<body>
	<center>
		<img src="image/qna.jpg" width=500height=50>
		<p>
		
		<form method=post action="insert_ok.jsp" id="frm">
		
		<table border=1 bordercolor="black" width=500 cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					
					<table border="0" width=500>
						<tr>
							<td width=15% align="right">�̸�</td>
							<td width=85% align="left">
							<input type="text" name=name size=12 id="name"></td>
						</tr>
						
						<tr>
							<td width=15% align="right">����</td>
							<td width=85% align="left">
							<input type="text" name=subject size=53 id="subject"></td>
						</tr>
						
						<tr>
							<td width=15% align="right">����</td>
							<td width=85% align="left">
							<textarea rows="10" cols="50" name=content id="content"></textarea>
						</tr>
						
						<tr>
							<td width=15% align="right">��й�ȣ</td>
							<td width=85% align="left">
							<input type="password" size=10 name=pwd id="pwd">
						</tr>
						
						<tr>
							<td colspan="2" align="center">
							<input type="button" value="�۾���" id="sendBtn">
							<input type="button" value="���" onclick="javascript:history.back()">  <!-- ��� �������� �� ȭ������ ������ -->
						</tr>
						
					</table>
					
				</td>
			</tr>
		</table>
		</form>
	</center>
</body>
</html>


<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">
/*
 *   selector : ���尴ü , �±׸�( $('�±׸�')=>$('tr')) , 
                ID�� ($('#ID��')) ,
                Class�� ($('.class��'))
             $(document)
 */
$(function(){
	$('#sendBtn').click(function(){
		var name=$('#name').val();
		//alert(name);
		// val() : get , val("aaa"): set
		//$('#name').val("ȫ�浿");
		if(name=="")
		{
			$('#name').focus();
			return;
		}
	});
});
</script>
</head>


<body>
  <center>
    <img src="image/qna.jpg" width=500 height=50>
    <p>
    
    <form method=post action="insert_ok.jsp" id="frm">
    <table border=1 bordercolor="black" width=500
     cellpadding="0" cellspacing="0">
      <tr>
        <td>
          <table border="0" width=500>
           <tr>
            <td width=15% align="right">�̸�</td>
            <td width=85% align="left">
             <input type="text" name=name size=12 id="name">
            </td>
           </tr>
           <tr>
            <td width=15% align="right">����</td>
            <td width=85% align="left">
             <input type="text" name=subject size=53 id="subject">
            </td>
           </tr>
           <tr>
            <td width=15% align="right">����</td>
            <td width=85% align="left">
             <textarea rows="10" cols="50" name=content id="content"></textarea>
            </td>
           </tr>
           <tr>
            <td width=15% align="right">��й�ȣ</td>
            <td width=85% align="left">
             <input type="password" size=10 name=pwd id="pwd">
            </td>
           </tr>
           <tr>
            <td colspan="2" align="center">
             <input type="button" value="�۾���" id="sendBtn">
             <input type="button" value="���"
              onclick="javascript:history.back()">
            </td>
           </tr>
          </table>
        </td>
      </tr>
    </table>
    </form>
   </center>
</body>
</html>























 --%>