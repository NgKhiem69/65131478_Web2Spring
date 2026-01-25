<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kết quả BMI</title>

<link rel="stylesheet" href="css/styles.css">
</head>

<body>

<div class="card result">
    <h2>KẾT QUẢ BMI</h2>

    <p>Chiều cao: ${height} m</p>
    <p>Cân nặng: ${weight} kg</p>
    <p><b>BMI:</b> ${bmi}</p>
    <p><b>Phân loại:</b> ${result}</p>

    <a href="BMI">Quay lại</a>
</div>

</body>
</html>
