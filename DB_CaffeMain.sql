-- Tạo database mới
CREATE DATABASE QLyCaPhe;
GO

USE QLyCaPhe;
GO

-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
    MaNV VARCHAR(20) PRIMARY KEY,
    TenNV NVARCHAR(50) NOT NULL,
    SDT VARCHAR(12) NOT NULL,
    NgaySinh DATE NOT NULL,
    LoaiNV NVARCHAR(50) NOT NULL
);

-- Tạo bảng Đăng nhập 
CREATE TABLE DangNhap (
    MaTK VARCHAR(50) PRIMARY KEY,
    MaNV VARCHAR(20) FOREIGN KEY REFERENCES NhanVien(MaNV),
    TenDangNhap VARCHAR(50) NOT NULL,
    MatKhau VARCHAR(50) NOT NULL,
    Quyen VARCHAR(50) NOT NULL
);


-- Tạo bảng Quản lý kho nguyên liệu
CREATE TABLE KhoNguyenLieu (
    MaNL VARCHAR(20) PRIMARY KEY,
    TenNL NVARCHAR(50) NOT NULL,
    NgayNhap DATE NOT NULL,
    SoLuong INT NOT NULL,
    DonViTinh NVARCHAR(20) NOT NULL,
    DonGia FLOAT NOT NULL,
    MaNV VARCHAR(20) FOREIGN KEY REFERENCES NhanVien(MaNV) -- Thêm ràng buộc ngoại
);

-- Tạo bảng Quản lý thực đơn
CREATE TABLE Menu (
    MaMon VARCHAR(30) PRIMARY KEY,
    TenMon NVARCHAR(50) NOT NULL,
    DonGia INT NOT NULL,
    HinhAnh NVARCHAR(50) NOT NULL 
);

-- Tạo bảng Quản lý bàn
CREATE TABLE Ban (
    SoBan VARCHAR(20) PRIMARY KEY,
    TinhTrang NVARCHAR(20) 
);

-- Tạo bảng Ghi nhận đơn hàng
CREATE TABLE DonHang (
    MaDH VARCHAR(20) PRIMARY KEY,
    SoBan VARCHAR(20) FOREIGN KEY REFERENCES Ban(SoBan),
    MaNV VARCHAR(20) FOREIGN KEY REFERENCES NhanVien(MaNV),
    NgayDat DATETIME NOT NULL,
    TongTien INT NOT NULL
);

-- Tạo bảng Chi tiết đơn hàng
CREATE TABLE ChiTietDonHang (
    MaDH VARCHAR(20),
    MaMon VARCHAR(30) FOREIGN KEY REFERENCES Menu(MaMon),
    SoLuong INT NOT NULL,
    ThanhTien INT NOT NULL,
    PRIMARY KEY (MaDH, MaMon),
    FOREIGN KEY (MaDH) REFERENCES DonHang(MaDH) -- Thêm ràng buộc ngoại
);


-- Tạo bảng Thanh toán
CREATE TABLE ThanhToan (
    MaTT VARCHAR(20) PRIMARY KEY,
    MaDH VARCHAR(20) FOREIGN KEY REFERENCES DonHang(MaDH),
    MaNV VARCHAR(20) FOREIGN KEY REFERENCES NhanVien(MaNV),
    NgayTT DATETIME NOT NULL,
    TongTien INT NOT NULL
);

-- Tạo bảng Báo cáo thống kê
CREATE TABLE BaoCaoThongKe (
    MaBaoCao INT PRIMARY KEY,
    Thang INT,
    Nam INT,
    DoanhThu INT,
    CONSTRAINT CK_Thang CHECK (Thang BETWEEN 1 AND 12),
    CONSTRAINT CK_Nam CHECK (Nam >= YEAR(GETDATE())),
    MaDH VARCHAR(20) FOREIGN KEY REFERENCES DonHang(MaDH) -- Thêm ràng buộc ngoại
);


-- Dữ liệu cho bảng Nhân viên
INSERT INTO NhanVien (MaNV, TenNV, SDT, NgaySinh, LoaiNV)
VALUES 
    ('NV001', N'Trần Văn A', '0123456789', '1990-01-15', N'Quản lý'),
    ('NV002', N'Nguyễn Thị B', '0987654321', '1995-03-20', N'Nhân viên'),
    ('NV003', N'Lê Văn C', '0365478912', '1992-07-10', N'Nhân viên');

-- Dữ liệu cho bảng Đăng nhập
INSERT INTO DangNhap (MaTK, MaNV, TenDangNhap, MatKhau, Quyen)
VALUES 
    ('TK001', 'NV001', 'tranvana', '123456', 'Admin'),
    ('TK002', 'NV002', 'nguyenthb', 'abcdef', 'User'),
    ('TK003', 'NV003', 'levanc', 'password', 'User');

-- Dữ liệu cho bảng Quản lý kho nguyên liệu
INSERT INTO KhoNguyenLieu (MaNL, TenNL, NgayNhap, SoLuong, DonViTinh, DonGia, MaNV)
VALUES 
    ('NL001', N'Cà phê', '2024-05-27', 100, N'kg', 10000, 'NV001'),
    ('NL002', N'Đường', '2024-05-27', 50, N'kg', 5000, 'NV002'),
    ('NL003', N'Sữa', '2024-05-27', 80, N'hộp', 20000, 'NV003'),
    ('NL004', N'Bột sữa', '2024-05-27', 80, N'Hộp', 15000, 'NV001'),
    ('NL005', N'Chanh', '2024-05-27', 30, N'Kg', 7000, 'NV001'),
    ('NL006', N'Đào', '2024-05-27', 40, N'Hộp', 25000, 'NV001');


-- Dữ liệu cho bảng Quản lý thực đơn (Menu)
INSERT INTO MENU (MaMon, TenMon, DonGia, HinhAnh) VALUES
('M001', N'Cà phê đen', 15000, 'h1.jpg'),
('M002', N'Cà phê sữa', 20000, 'h2.jpg'),
('M003', N'Bạc xỉu', 22000, 'h3.jpg'),
('M004', N'Cacao', 25000, 'h4.jpg'),
('M005', N'Cà phê dừa', 25000, 'h5.jpg'),
('M006', N'Cà phê muối', 25000, 'h6.jpg'),
('M007', N'Sữa tươi kẹp đường', 35000, 'h7.jpg'),
('M008', N'Sữa chua dẻo', 18000, 'h8.jpg'),
('M009', N'Sữa chua hũ', 12000, 'h9.jpg'),
('M010', N'Sữa chua đá', 20000, 'h10.jpg'),
('M011', N'Sữa chua mix vị', 25000, 'h11.jpg'),
('M012', N'Trà chanh', 20000, 'h12.jpg'),
('M013', N'Trà đào cam sả', 30000, 'h13.jpg'),
('M014', N'Trà gừng', 20000, 'h14.jpg'),
('M015', N'Trà dâu tây hồng', 30000, 'h15.jpg'),
('M016', N'Trà việt quất thanh long', 30000, 'h16.jpg'),
('M017', N'Trà chanh dây cam bưởi', 30000, 'h17.jpg'),
('M018', N'Trà chanh dây dứa lưới', 30000, 'h18.jpg'),
('M019', N'Nước chanh', 20000, 'h19.jpg'),
('M020', N'Nước ngọt các loại', 22000, 'h20.jpg');

-- Dữ liệu cho bảng Quản lý bàn
INSERT INTO Ban (SoBan, TinhTrang)
VALUES 
    ('B001', N'Bàn trống'),
    ('B002', N'Bàn đã đặt'),
    ('B003', N'Bàn có khách');

-- Dữ liệu cho bảng Ghi nhận đơn hàng
INSERT INTO DonHang (MaDH, SoBan, MaNV, NgayDat, TongTien)
VALUES 
    ('DH001', 'B001', 'NV002', '2024-05-16 10:30:00', 35000),
    ('DH002', 'B003', 'NV003', '2024-05-16 12:00:00', 50000),
    ('DH003', 'B002', 'NV001', '2024-05-16 15:45:00', 42000);

-- Dữ liệu cho bảng Chi tiết đơn hàng
INSERT INTO ChiTietDonHang (MaDH, MaMon, SoLuong, ThanhTien)
VALUES 
    ('DH001', 'M001', 2, 30000),
    ('DH001', 'M002', 1, 18000),
    ('DH002', 'M003', 3, 60000),
    ('DH003', 'M002', 2, 36000);


-- Dữ liệu cho bảng Thanh toán
INSERT INTO ThanhToan (MaTT, MaDH, MaNV, NgayTT, TongTien)
VALUES 
    ('TT001', 'DH001', 'NV002', '2024-05-16 11:30:00', 35000),
    ('TT002', 'DH002', 'NV003', '2024-05-16 12:45:00', 50000),
    ('TT003', 'DH003', 'NV001', '2024-05-16 17:00:00', 42000);

-- Dữ liệu cho bảng Báo cáo thống kê
INSERT INTO BaoCaoThongKe (MaBaoCao, Thang, Nam, DoanhThu, MaDH)
VALUES 
    (1, 5, 2024, 127000, 'DH001'),
    (2, 5, 2024, 120000, 'DH002'),
    (3, 5, 2024, 100000, 'DH003');

	SELECT * FROM NhanVien;
	SELECT * FROM DangNhap;
	SELECT * FROM KhoNguyenLieu;
	SELECT * FROM Menu;
	SELECT * FROM Ban;
	SELECT * FROM DonHang;
	SELECT * FROM ChiTietDonHang;
	SELECT * FROM ThanhToan;
	SELECT * FROM BaoCaoThongKe;


-- Thêm cột Ban vào bảng Ban
ALTER TABLE Ban
ADD Ban NVARCHAR(50);

INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B004', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B005', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B006', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B007', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B008', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B009', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B010', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B011', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B012', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B013', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B014', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B015', N'Bàn trống');
INSERT INTO Ban (SoBan, TinhTrang) VALUES ('B016', N'Bàn trống');

-- Cập nhật tên bàn cho 16 bàn
UPDATE Ban SET Ban = N'Bàn 1' WHERE SoBan = 'B001';
UPDATE Ban SET Ban = N'Bàn 2' WHERE SoBan = 'B002';
UPDATE Ban SET Ban = N'Bàn 3' WHERE SoBan = 'B003';
UPDATE Ban SET Ban = N'Bàn 4' WHERE SoBan = 'B004';
UPDATE Ban SET Ban = N'Bàn 5' WHERE SoBan = 'B005';
UPDATE Ban SET Ban = N'Bàn 6' WHERE SoBan = 'B006';
UPDATE Ban SET Ban = N'Bàn 7' WHERE SoBan = 'B007';
UPDATE Ban SET Ban = N'Bàn 8' WHERE SoBan = 'B008';
UPDATE Ban SET Ban = N'Bàn 9' WHERE SoBan = 'B009';
UPDATE Ban SET Ban = N'Bàn 10' WHERE SoBan = 'B010';
UPDATE Ban SET Ban = N'Bàn 11' WHERE SoBan = 'B011';
UPDATE Ban SET Ban = N'Bàn 12' WHERE SoBan = 'B012';
UPDATE Ban SET Ban = N'Bàn 13' WHERE SoBan = 'B013';
UPDATE Ban SET Ban = N'Bàn 14' WHERE SoBan = 'B014';
UPDATE Ban SET Ban = N'Bàn 15' WHERE SoBan = 'B015';
UPDATE Ban SET Ban = N'Bàn 16' WHERE SoBan = 'B016';

-- Kiểm tra kết quả
SELECT * FROM Ban;

-- Thêm cột Status vào bảng DonHang với giá trị mặc định là 1
ALTER TABLE DonHang
ADD Status BIT DEFAULT 1;

-- Cập nhật giá trị của cột Status cho tất cả các hàng hiện tại
UPDATE DonHang
SET Status = 1;

-- Kiểm tra kết quả
SELECT * FROM DonHang;
-----------------------------------------------------

CREATE TRIGGER trg_UpdateStatusOnPayment
ON [dbo].[ThanhToan]
AFTER INSERT
AS
BEGIN
    -- Cập nhật cột Status trong bảng DonHang thành 0 khi có bản ghi mới trong bảng ThanhToan
    UPDATE d
    SET d.Status = 0
    FROM [dbo].[DonHang] d
    INNER JOIN inserted i ON d.MaDH = i.MaDH
END
GO
-----------------------------------------------------
CREATE TRIGGER UpdateTinhTrangBanThanhToan
ON dbo.ThanhToan
AFTER INSERT
AS
BEGIN
    -- Cập nhật tình trạng bàn thành 'Bàn trống' khi đơn hàng được thanh toán
    UPDATE b
    SET b.TinhTrang = N'Bàn trống'
    FROM dbo.Ban b
    INNER JOIN dbo.DonHang dh ON dh.SoBan = b.SoBan
    INNER JOIN inserted i ON i.MaDH = dh.MaDH;
END;

-----------------------------------------------------
CREATE TRIGGER UpdateTinhTrangBanKhiDatHang
ON dbo.DonHang
AFTER INSERT
AS
BEGIN
    -- Cập nhật tình trạng bàn thành 'Có khách' khi có đơn hàng mới
    UPDATE b
    SET b.TinhTrang = N'Có khách'
    FROM dbo.Ban b
    INNER JOIN inserted i ON i.SoBan = b.SoBan;
END;