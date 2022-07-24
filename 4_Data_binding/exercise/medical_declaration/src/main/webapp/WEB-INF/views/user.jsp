<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your medical declaration</h1>
<h3>Họ và tên: ${form.name}</h3>
<h3>Năm sính: ${form.year}</h3>
<h3>Giới tính: ${form.gender}</h3>
<h3>Quốc tịch: ${form.national}</h3>
<h3>Số CMND: ${form.identity}</h3>
<h3>Thông tin đi lại: ${form.vehicle}</h3>
<h3>Số hiệu phương tiện: ${form.plate}</h3>
<h3>Số ghế: ${form.chair}</h3>
<h3>Ngày khởi hành: ${form.datebegin} </h3>
<h3>Ngày kết thúc: ${form.dateend}</h3>
<h3>Trong vòng 14 ngày: ${form.history}</h3>
<h3>Tỉnh/thành: ${form.city}</h3>
<h3>Quận/huyện: ${form.district}</h3>
<h3>Phường/xã: ${form.ward}</h3>
<h3>Địa chỉ nơi ở: ${form.address}</h3>
<h3>Điện thoại: ${form.tel}</h3>
<h3>Email: ${form.mail}</h3>
<h3>Sốt? ${form.sot}</h3>
<h3>Ho: ${form.ho}</h3>
<h3>Khó thở? ${form.khotho}</h3>
<h3>Nôn/buồn nôn? ${form.non}</h3>
<h3>Tiêu chảy? ${form.tieuchay}</h3>
<h3>Xuất huyết ngoài da? ${form.xhngoaida}</h3>
<h3>Nổi ban ngoài da? ${form.noiban}</h3>
<h3>Đến trang trại chăn nuôi/ chợ buôn bán động vật sống/ cơ sở giết mổ động vật/ tiếp xúc động vật? ${form.tiepxucdongvat} </h3>
<h3>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV? ${form.tiepxucnguoi}</h3>
<h3></h3>
</body>
</html>
