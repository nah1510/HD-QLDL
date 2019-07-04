-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 04, 2019 lúc 01:21 PM
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
(1, 0, 4, 2, 4, 1056000);

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
(0, 'Duy Nguyễn', 0, '0961543650', '219 Đường số 12', 0, 'duy@gmail.com', '2019-06-30', 2056000),
(1, 'Hân Phạm', 1, '0965841120', '56 Nguyễn Thiện Thuật', 1, 'HanAnLon@gmail.com', '0000-00-00', 0),
(2, 'Hiếu Nhỏ', 1, 'may', '56 Nguyễn Thiện Thuật', 1, 'HanAnLon@gmail.com', '0000-00-00', 0),
(3, 'Hiếu Lớn', 1, 'may', '56 Nguyễn Thiện Thuật', 1, 'HanAnLon@gmail.com', '0000-00-00', 0),
(4, 'Hải Đen', 1, 'may', '56 Nguyễn Thiện Thuật', 1, 'HanAnLon@gmail.com', '0000-00-00', 0),
(5, 'Hùng Seol', 1, 'may', '56 Nguyễn Thiện Thuật', 1, 'HanAnLon@gmail.com', '0000-00-00', 0),
(6, 'Đức Cống', 1, 'may', '56 Nguyễn Thiện Thuật', 1, 'HanAnLon@gmail.com', '0000-00-00', 0),
(7, 'Công Nghệ', 1, 'may', '56 Nguyễn Thiện Thuật', 1, 'HanAnLon@gmail.com', '0000-00-00', 0),
(8, 'Thông Tin', 1, 'may', '56 Nguyễn Thiện Thuật', 1, 'HanAnLon@gmail.com', '0000-00-00', 0);

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
(3, 'Coca cola', 10000, 5),
(4, 'Pepsi', 11000, 7),
(5, 'tiger', 13000, 9),
(6, '333', 14000, 15),
(7, 'xá xị', 15000, 20),
(8, '7 up', 12000, 5),
(9, 'pepsi cola', 11000, 14),
(10, 'trà xanh không độ', 12000, 16),
(11, 'trà vải', 15000, 12),
(12, 'trà olong', 16000, 10),
(13, 'trà sửa machiato', 12000, 3),
(14, 'bò húc', 11000, 40),
(15, 'C2', 12000, 51),
(16, 'C2 vị đào', 13000, 22),
(17, 'lipton', 15000, 32),
(18, 'revise', 16000, 52),
(19, 'nước cam ép', 13000, 23),
(20, 'nòng nọc', 17000, 49);

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
(0, 0, 2056000, '2019-07-03');

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
(3, 'Thủ Đức');

--
-- Chỉ mục cho các bảng đã đổ
--

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
