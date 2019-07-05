-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 05, 2019 lúc 11:20 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.2.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qldl`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baocaodoanhso`
--

CREATE TABLE `baocaodoanhso` (
  `MaBaoCaoDoanhSo` int(10) NOT NULL,
  `Thang` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `baocaodoanhso`
--

INSERT INTO `baocaodoanhso` (`MaBaoCaoDoanhSo`, `Thang`) VALUES
(0, 6),
(1, 7),
(2, 7),
(3, 7),
(4, 7),
(5, 7),
(6, 6),
(7, 7),
(8, 7),
(9, 7),
(10, 7),
(11, 7),
(12, 7),
(13, 7),
(14, 7),
(15, 7),
(16, 7),
(17, 7),
(18, 7),
(19, 7),
(20, 7),
(21, 7),
(22, 7),
(23, 7),
(24, 7),
(25, 7),
(26, 7),
(27, 7),
(28, 7),
(29, 7),
(30, 7),
(31, 7),
(32, 7),
(33, 7),
(34, 7),
(35, 7),
(36, 7),
(37, 7),
(38, 7),
(39, 7),
(40, 7),
(41, 7),
(42, 7),
(43, 7),
(44, 7),
(45, 7),
(46, 7),
(47, 7),
(48, 7),
(49, 7),
(50, 7),
(51, 7),
(52, 7),
(53, 7),
(54, 7),
(55, 7),
(56, 7),
(57, 7),
(58, 7),
(59, 7),
(60, 7),
(61, 7),
(62, 7),
(63, 7),
(64, 7),
(65, 7),
(66, 7),
(67, 7),
(68, 7),
(69, 7),
(70, 7),
(71, 7),
(72, 7),
(73, 7),
(74, 7),
(75, 7),
(76, 7),
(77, 7),
(78, 7),
(79, 7),
(80, 7),
(81, 7),
(82, 7),
(83, 7),
(84, 7),
(85, 7),
(86, 7),
(87, 7),
(88, 7),
(89, 7),
(90, 7),
(91, 7),
(92, 7),
(93, 7),
(94, 7),
(95, 7),
(96, 6),
(97, 7),
(98, 6),
(99, 7),
(100, 7),
(101, 7),
(102, 7),
(103, 7),
(104, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieuxuat`
--

CREATE TABLE `ctphieuxuat` (
  `MaCTPhieuXuat` int(10) NOT NULL,
  `MaPhieuXuat` int(10) NOT NULL,
  `MaMatHang` int(10) NOT NULL,
  `MaDVT` int(10) NOT NULL,
  `SoLuongXuat` int(10) NOT NULL,
  `ThanhTien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `ctphieuxuat`
--

INSERT INTO `ctphieuxuat` (`MaCTPhieuXuat`, `MaPhieuXuat`, `MaMatHang`, `MaDVT`, `SoLuongXuat`, `ThanhTien`) VALUES
(0, 0, 3, 0, 100, 1000000),
(1, 0, 4, 2, 4, 1056000),
(2, 1, 3, 2, 10, 2400000),
(3, 1, 15, 2, 5, 1440000),
(4, 2, 4, 0, 50, 550000),
(5, 2, 3, 1, 2, 120000),
(6, 2, 15, 1, 5, 360000),
(7, 3, 3, 0, 5, 50000),
(8, 4, 3, 0, 5, 50000),
(9, 5, 3, 0, 5, 50000),
(10, 5, 3, 1, 5, 300000),
(11, 6, 4, 2, 5, 1320000),
(12, 7, 3, 2, 5, 1200000),
(13, 8, 3, 0, 100, 1000000),
(14, 8, 4, 0, 100, 1100000),
(15, 9, 3, 0, 50, 500000),
(16, 10, 8, 2, 5, 1440000),
(17, 11, 15, 2, 10, 2880000),
(18, 12, 8, 0, 30, 360000),
(19, 13, 8, 1, 20, 1440000),
(20, 14, 3, 0, 10, 100000),
(21, 15, 3, 2, 10, 2400000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donvitinh`
--

CREATE TABLE `donvitinh` (
  `MaDVT` int(10) NOT NULL,
  `TenDVT` varchar(100) CHARACTER SET ucs2 COLLATE ucs2_vietnamese_ci NOT NULL,
  `SoLuongDVT` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `donvitinh`
--

INSERT INTO `donvitinh` (`MaDVT`, `TenDVT`, `SoLuongDVT`) VALUES
(0, 'Chai', 1),
(1, 'Lóc', 6),
(2, 'Thùng', 24);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hosodayly`
--

CREATE TABLE `hosodayly` (
  `MaDL` int(10) NOT NULL,
  `TenDL` varchar(100) CHARACTER SET ucs2 COLLATE ucs2_vietnamese_ci NOT NULL,
  `MaLoaiDL` int(10) NOT NULL,
  `DienThoai` varchar(100) NOT NULL,
  `DiaChi` varchar(100) CHARACTER SET ucs2 COLLATE ucs2_vietnamese_ci NOT NULL,
  `MaQuan` int(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `NgayTiepNhan` date NOT NULL,
  `TienNo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `hosodayly`
--

INSERT INTO `hosodayly` (`MaDL`, `TenDL`, `MaLoaiDL`, `DienThoai`, `DiaChi`, `MaQuan`, `Email`, `NgayTiepNhan`, `TienNo`) VALUES
(0, 'Duy Nguyễn', 0, '0961543650', '219 Đường số 12', 0, 'duy@gmail.com', '2019-07-01', 1000000),
(1, 'Hân Phạm', 0, '0965841120', '56 Nguyễn Thiện Thuật', 1, 'HanAnLon@gmail.com', '2019-07-01', 3040000),
(2, 'Hiếu Nhỏ', 1, '0965451635', '36 Cách Mạng Tháng 8', 0, 'HanAnLon@gmail.com', '2019-07-02', 530000),
(3, 'Bình', 0, '056321854', '58 Đường Số 8', 2, 'HanAnLon@gmail.com', '2019-07-02', 450000),
(4, 'An', 1, '0593698524', '10 Hàn Thuyên', 1, 'anlangthang@gmail.com', '2019-07-03', 500000),
(5, 'Hùng Seol', 0, '0123654879', '4/3 Đờng số 10', 2, 'SeolHung@gmail.com', '2019-07-03', 4320000),
(6, 'Đức Cống', 1, '0521436978', '422Trần Khánh Dư', 2, 'duccong@gmail.com', '2019-07-03', 460000),
(7, 'Công Nghệ', 1, '0522748693', '666 Phạm Văn Đồng', 3, 'ut@gmail.com', '2019-07-03', 1440000),
(8, 'Thông Tin', 1, '0522748644', '98 Nguyễn Du', 3, 'ui@gmail.com', '2019-07-03', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaidaily`
--

CREATE TABLE `loaidaily` (
  `MaLoaiDL` int(100) NOT NULL,
  `TenLoaiDL` varchar(100) NOT NULL,
  `NoToiDa` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `loaidaily`
--

INSERT INTO `loaidaily` (`MaLoaiDL`, `TenLoaiDL`, `NoToiDa`) VALUES
(0, 'Loai 1', 10000000),
(1, 'Loai 2', 5000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mathang`
--

CREATE TABLE `mathang` (
  `MaMatHang` int(10) NOT NULL,
  `TenMatHang` varchar(100) CHARACTER SET ucs2 COLLATE ucs2_vietnamese_ci NOT NULL,
  `DonGia` int(10) NOT NULL,
  `SoLuongTon` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `mathang`
--

INSERT INTO `mathang` (`MaMatHang`, `TenMatHang`, `DonGia`, `SoLuongTon`) VALUES
(3, 'Coca cola', 10000, 1025),
(4, 'Pepsi', 11000, 7234201),
(5, 'tiger', 13000, 92054224),
(6, '333', 14000, 15204242),
(8, '7 up', 12000, 521204242),
(9, 'pepsi cola', 11000, 14210424),
(15, 'C2', 12000, 5121210),
(17, 'lipton', 15000, 3212020),
(18, 'revise', 16000, 424242);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuthutien`
--

CREATE TABLE `phieuthutien` (
  `MaPhieuThuTien` int(10) NOT NULL,
  `MaDaiLy` int(10) NOT NULL,
  `SoTienThu` int(10) NOT NULL,
  `NgayThuTien` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `phieuthutien`
--

INSERT INTO `phieuthutien` (`MaPhieuThuTien`, `MaDaiLy`, `SoTienThu`, `NgayThuTien`) VALUES
(0, 0, 456000, '2019-07-04'),
(1, 0, 20000, '2019-07-05'),
(2, 1, 100000, '2019-07-05'),
(3, 1, 100000, '2019-07-05'),
(4, 1, 100000, '2019-07-05'),
(5, 1, 3000000, '2019-07-05'),
(6, 0, 2000000, '2019-07-05'),
(7, 1, 2000000, '2019-07-05'),
(8, 2, 500000, '2019-07-05'),
(9, 0, 100000, '2019-07-05'),
(10, 0, 1000000, '2019-07-05');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPhieuXuat` int(10) NOT NULL,
  `MaDL` int(10) NOT NULL,
  `TongTriGia` int(10) NOT NULL,
  `NgayLapPhieu` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`MaPhieuXuat`, `MaDL`, `TongTriGia`, `NgayLapPhieu`) VALUES
(0, 0, 2056000, '2019-07-03'),
(1, 1, 3840000, '2019-07-05'),
(2, 2, 1030000, '2019-07-05'),
(3, 3, 50000, '2019-07-05'),
(4, 3, 50000, '2019-07-05'),
(5, 3, 350000, '2019-07-05'),
(6, 0, 1320000, '2019-07-05'),
(7, 0, 1200000, '2019-07-05'),
(8, 1, 2100000, '2019-07-05'),
(9, 4, 500000, '2019-07-05'),
(10, 5, 1440000, '2019-07-05'),
(11, 5, 2880000, '2019-07-05'),
(12, 6, 360000, '2019-07-05'),
(13, 7, 1440000, '2019-07-05'),
(14, 6, 100000, '2019-07-05'),
(15, 1, 2400000, '2019-07-05');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quan`
--

CREATE TABLE `quan` (
  `MaQuan` int(10) NOT NULL,
  `TenQuan` varchar(100) CHARACTER SET ucs2 COLLATE ucs2_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `quan`
--

INSERT INTO `quan` (`MaQuan`, `TenQuan`) VALUES
(0, 'Tân Bình'),
(1, 'Bình Tân'),
(2, 'Bình thạnh'),
(3, 'Thủ Đức');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thamso`
--

CREATE TABLE `thamso` (
  `SoLuongLoaiDaiLy` int(2) NOT NULL,
  `SoDaiLyToiDa` int(2) NOT NULL,
  `SoMatHang` int(2) NOT NULL,
  `SoDonViTinh` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `thamso`
--

INSERT INTO `thamso` (`SoLuongLoaiDaiLy`, `SoDaiLyToiDa`, `SoMatHang`, `SoDonViTinh`) VALUES
(3, 3, 11, 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `baocaodoanhso`
--
ALTER TABLE `baocaodoanhso`
  ADD PRIMARY KEY (`MaBaoCaoDoanhSo`);

--
-- Chỉ mục cho bảng `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD PRIMARY KEY (`MaCTPhieuXuat`),
  ADD UNIQUE KEY `MaCTPhieuXuat` (`MaCTPhieuXuat`);

--
-- Chỉ mục cho bảng `donvitinh`
--
ALTER TABLE `donvitinh`
  ADD PRIMARY KEY (`MaDVT`),
  ADD UNIQUE KEY `MaDVT` (`MaDVT`);

--
-- Chỉ mục cho bảng `hosodayly`
--
ALTER TABLE `hosodayly`
  ADD PRIMARY KEY (`MaDL`),
  ADD UNIQUE KEY `MaDL` (`MaDL`);

--
-- Chỉ mục cho bảng `loaidaily`
--
ALTER TABLE `loaidaily`
  ADD PRIMARY KEY (`MaLoaiDL`),
  ADD UNIQUE KEY `MaLoaiDL` (`MaLoaiDL`);

--
-- Chỉ mục cho bảng `mathang`
--
ALTER TABLE `mathang`
  ADD PRIMARY KEY (`MaMatHang`),
  ADD UNIQUE KEY `MaMatHang` (`MaMatHang`);

--
-- Chỉ mục cho bảng `phieuthutien`
--
ALTER TABLE `phieuthutien`
  ADD PRIMARY KEY (`MaPhieuThuTien`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MaPhieuXuat`),
  ADD UNIQUE KEY `MaPhieuXuat` (`MaPhieuXuat`);

--
-- Chỉ mục cho bảng `quan`
--
ALTER TABLE `quan`
  ADD PRIMARY KEY (`MaQuan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
