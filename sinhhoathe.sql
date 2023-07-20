Create database sinhhoathe;
USE sinhhoathe;

CREATE TABLE BANGIAOVU(
    MAGIAOVU CHAR(5),
    MATKHAU VARCHAR(15),
    CONSTRAINT PK_MAGIAOVU PRIMARY KEY (MAGIAOVU)
);

CREATE TABLE MONHOC(
    MAMONHOC CHAR(5),
    TENMONHOC NVARCHAR(30),
    HOCPHI MONEY,
    CONSTRAINT PK_MAMONHOC PRIMARY KEY (MAMONHOC)
);

CREATE TABLE GIAOVIEN(
    MAGIAOVIEN CHAR(5),
    TENGIAOVIEN NVARCHAR(30),
    MAMONHOC CHAR(5),
    CONSTRAINT PK_MAGIAOVIEN PRIMARY KEY (MAGIAOVIEN),
    CONSTRAINT FK_MMONHOC FOREIGN KEY (MAMONHOC) REFERENCES MONHOC(MAMONHOC)
);

CREATE TABLE LOPHOC (
    MALOPHOC CHAR(5),
    PHONGHOC NVARCHAR(15),
    SOBUOI NVARCHAR(15),
    NGAYKHAIGIANG DATE,
    THOIGIANHOC NVARCHAR(15),
    GIOHOC NVARCHAR(15),
    SLTOIDA INT,
    SLDADANGKY INT,
    MAGIAOVIEN CHAR(5),
    MAMONHOC CHAR(5),
    CONSTRAINT PK_MALOPHOC PRIMARY KEY (MALOPHOC),
    CONSTRAINT FK_MAGIAOVIEN FOREIGN KEY (MAGIAOVIEN) REFERENCES GIAOVIEN(MAGIAOVIEN),
    CONSTRAINT FK_MAMONHOC FOREIGN KEY (MAMONHOC) REFERENCES MONHOC(MAMONHOC)

);

CREATE TABLE NGUOIDANGKY(
    HOTENHV NVARCHAR(30),
    SDT NVARCHAR(30),
    DIACHI NVARCHAR(30),
    NGAYSINH DATE,
    EMAIL NVARCHAR(30),
    HOTENPH NVARCHAR(30),
    CONSTRAINT PK_ACCOUNT PRIMARY KEY (HOTENHV, SDT)
);
CREATE TABLE DANGKY(
    HOTENHV NVARCHAR(30),
    SDT NVARCHAR(30),
    MALOPHOC CHAR(5),
    TRANGTHAI NVARCHAR(30),
    CONSTRAINT PK_HV_MALOPHOC PRIMARY KEY (HOTENHV, SDT, MALOPHOC),
    CONSTRAINT FK_HOTENHV_SDT FOREIGN KEY (HOTENHV, SDT) REFERENCES NGUOIDANGKY(HOTENHV, SDT),
    
    CONSTRAINT FK_MALOPHOC FOREIGN KEY (MALOPHOC) REFERENCES LOPHOC(MALOPHOC)
);
-- check 
SELECT lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, giaovien.tengiaovien, 
lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc,lophoc.sltoida,
 monhoc.hocphi, count(*) as sohocvien
FROM Lophoc 
JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc
JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien
JOIN dangky on lophoc.malophoc = dangky.malophoc
WHERE dangky.trangthai = '0'
GROUP BY lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, 
giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang,
lophoc.thoigianhoc, lophoc.giohoc, lophoc.sltoida, monhoc.hocphi
ORDER BY sohocvien desc;

--Hien thi thong tin các lop hoc co the dang ky co sldadangky
SELECT monhoc.tenmonhoc, giaovien.tengiaovien, 
lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc, lophoc.sltoida,
 monhoc.hocphi, count(*) as sohocvien
FROM Lophoc 
JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc
JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien
JOIN dangky on lophoc.malophoc = dangky.malophoc
WHERE NGAYKHAIGIANG > (getDATE() - 7*2)
GROUP BY monhoc.tenmonhoc, giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang,
lophoc.thoigianhoc, lophoc.giohoc, lophoc.sltoida, monhoc.hocphi;

--Hien thi thong tin các lop hoc co the dang ky 
SELECT monhoc.tenmonhoc, giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc, lophoc.sltoida, monhoc.hocphi
FROM Lophoc 
JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc
JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien
WHERE NGAYKHAIGIANG > (getDATE() - 7*2)


INSERT INTO GIAOVIEN VALUES('GV001', 'Nguyen Thi H', 'MH001');
INSERT INTO GIAOVIEN VALUES('GV002', 'Nguyen Thi M', 'MH002');
INSERT INTO GIAOVIEN VALUES('GV003', 'Nguyen Van V', 'MH003');
INSERT INTO GIAOVIEN VALUES('GV004', 'Nguyen Van B', 'MH004');
INSERT INTO GIAOVIEN VALUES('GV005', 'Nguyen Van H', 'MH001');


INSERT INTO MONHOC VALUES('MH001', 'Hoi Hoa', 300000);
INSERT INTO MONHOC VALUES('MH002', 'Mua', 500000);
INSERT INTO MONHOC VALUES('MH003', 'Co Vua', 700000);
INSERT INTO MONHOC VALUES('MH004', 'Bong Ban', 200000);

INSERT INTO LOPHOC VALUES('L0005', 'Phong V01', '5 buoi', '2022-12-09', 'Ca Tuan', '16h30 - 17h30', '10', '0', 'GV003', 'MH003');
INSERT INTO LOPHOC VALUES('L0006', 'Phong B01', '3 buoi', '2023-07-09', 'Thu 2, 4, 6', '15h30 - 16h30', '5', '0', 'GV004', 'MH004');
INSERT INTO LOPHOC VALUES('L0007', 'Phong V01', '3 buoi', '2022-12-10', 'Thu 3, 5, 7', '15h30 - 16h30', '5', '0', 'GV004', 'MH004');

UPDATE MONHOC SET MAMONHOC = 'MH002' WHERE MAMONHOC = 'MN002';
UPDATE GIAOVIEN SET MAMONHOC = 'MH002' WHERE MAMONHOC = 'MN002';

DELETE FROM MONHOC;
DELETE FROM GIAOVIEN;
DELETE FROM LOPHOC;
DELETE FROM NguoiDangKy;


SELECT * FROM NGUOIDANGKY WHERE NGAYSINH > (getDate() - 5*365) OR NGAYSINH < (getDate() - 15*365);

--Hien thi thong tin các lop hoc cua hoc vien da dang ky 
SELECT dangky.hotenhv, dangky.sdt, monhoc.tenmonhoc, giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc, monhoc.hocphi
FROM Lophoc 
JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc
JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien
JOIN dangky on lophoc.malophoc = dangky.malophoc
WHERE hotenhv = 'be H' And sdt = '0912345678';

--Hien thi tong hoc phi cua hoc vien
SELECT dangky.hotenhv, dangky.sdt, sum(monhoc.hocphi) as TongHocPhi
FROM DangKy
JOIN LOPHOC ON DangKy.malophoc = LopHoc.malophoc
JOIN GIAOVIEN ON lophoc.magiaovien = giaovien.magiaovien
JOIN MONHOC ON lophoc.mamonhoc = monhoc.mamonhoc
GROUP BY dangky.hotenhv, dangky.sdt;

UPDATE DANGKY SET HOTENHV = 'BE J', SDT = '0912345679' WHERE HOTENHV = 'BE F';
UPDATE NGUOIDANGKY SET NGAYSINH = '2017-09-09' WHERE HOTENHV = 'BE F';


--Hien thi thong tin ca nhan hv cho xac nhan
SELECT nguoidangky.hotenhv, nguoidangky.sdt, nguoidangky.diachi, nguoidangky.ngaysinh, nguoidangky.email,
nguoidangky.hotenph, dangky.malophoc, dangky.trangthai
FROM NguoiDangKy
JOIN DangKy ON nguoidangky.hotenhv = dangky.hotenhv AND nguoidangky.sdt = dangky.sdt
WHERE TrangThai = '0';

--Hien Thi HV co ngay sinh tu 5 den 15 tuoi
SELECT * FROM NGUOIDANGKY WHERE NGAYSINH < (getDate() - 5*365) AND NGAYSINH > (getDate() - 15*365);

SELECT * FROM NGUOIDANGKY;