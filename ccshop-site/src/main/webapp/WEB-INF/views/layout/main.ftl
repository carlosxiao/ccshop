<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${title}</title>
        <link rel="icon" href="images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
        <link rel="bookmark" href="images/favicon.ico" type="image/x-icon" />
        <link type="text/css" rel="stylesheet" href="${ctx}/src/main/webapp/style/reset.css">
        <link type="text/css" rel="stylesheet" href="${ctx}/src/main/webapp/style/main.css">
		<script type="text/javascript" src="${ctx}/src/main/webapp/js/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="${ctx}/src/main/webapp/js/site.js"></script>
        <!--[if IE 6]>
		<script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
		<script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
        <![endif]-->

		<script type="text/javascript">
			var ctx = "${ctx!}";
		</script>
		${head}
	</head>
	<body>
		<#include "header.ftl">
			${body}
		<#include "footer.ftl">
	</body>
</html>