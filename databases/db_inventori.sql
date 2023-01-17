-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20221024.fd16af9f6a
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2022 at 06:44 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_inventori`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `id_barang` varchar(200) NOT NULL,
  `nama_barang` varchar(200) NOT NULL,
  `keterangan` varchar(200) NOT NULL,
  `satuan` varchar(255) NOT NULL,
  `stok` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`id_barang`, `nama_barang`, `keterangan`, `satuan`, `stok`) VALUES
('B00001', 'Fakenalis', 'Kuku Palsu', 'Pcs', '30'),
('B00002', 'Gel Polish', 'Kutek', 'Kutek', '20');

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang_keluar`
--

CREATE TABLE `tb_barang_keluar` (
  `id_bk` varchar(255) NOT NULL,
  `id_client` varchar(255) NOT NULL,
  `nama_client` varchar(255) NOT NULL,
  `id_barang` varchar(200) NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `satuan` varchar(255) NOT NULL,
  `harga_satuan` varchar(255) NOT NULL,
  `harga_pengeluaran` varchar(255) NOT NULL,
  `keterangan` varchar(255) NOT NULL,
  `jumlah_k` int(255) NOT NULL,
  `tanggal_k` date NOT NULL,
  `total_pengeluaran` varchar(255) NOT NULL,
  `pembayaran` varchar(255) NOT NULL,
  `kembalian` varchar(255) NOT NULL,
  `keuntungan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barang_keluar`
--

INSERT INTO `tb_barang_keluar` (`id_bk`, `id_client`, `nama_client`, `id_barang`, `nama_barang`, `satuan`, `harga_satuan`, `harga_pengeluaran`, `keterangan`, `jumlah_k`, `tanggal_k`, `total_pengeluaran`, `pembayaran`, `kembalian`, `keuntungan`) VALUES
('BK00001', 'C00001', 'Ahmad Randi', 'B00001', 'Fakenalis', 'Pcs', '18000', '25000', 'Kuku palsu', 20, '2022-11-23', '25000', '25000', '0', '30000'),
('BK00002', 'C00001', 'Ahmad Randi', 'B00002', 'Gel Polish', 'Kutek', '20000', '25000', 'Kutek', 30, '2022-11-24', '750000', '800000', '50000', '150000');

--
-- Triggers `tb_barang_keluar`
--
DELIMITER $$
CREATE TRIGGER `Barang Keluar` AFTER INSERT ON `tb_barang_keluar` FOR EACH ROW BEGIN
	UPDATE tb_barang SET stok= stok - NEW.jumlah_k
	WHERE nama_barang = NEW.nama_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang_masuk`
--

CREATE TABLE `tb_barang_masuk` (
  `id_bm` varchar(255) NOT NULL,
  `id_supplier` varchar(255) NOT NULL,
  `nama_supplier` varchar(255) NOT NULL,
  `id_barang` varchar(200) NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `satuan` varchar(255) NOT NULL,
  `harga_satuan` varchar(255) NOT NULL,
  `keterangan` varchar(255) NOT NULL,
  `jumlah_m` int(255) NOT NULL,
  `tanggal_m` date NOT NULL,
  `total_pemasukan` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barang_masuk`
--

INSERT INTO `tb_barang_masuk` (`id_bm`, `id_supplier`, `nama_supplier`, `id_barang`, `nama_barang`, `satuan`, `harga_satuan`, `keterangan`, `jumlah_m`, `tanggal_m`, `total_pemasukan`) VALUES
('BM00001', 'S00002', 'Kpn Bangkrut', 'B00001', 'Fakenalis', 'Pcs', '18000', 'Kuku Palsu', 50, '2022-11-20', '900000'),
('BM00002', 'S00001', 'Maju Mundur', 'B00002', 'Gel Polish', 'Kutek', '20000', 'Kutek', 50, '2022-11-23', '1000000');

--
-- Triggers `tb_barang_masuk`
--
DELIMITER $$
CREATE TRIGGER `BarangMasuk` AFTER INSERT ON `tb_barang_masuk` FOR EACH ROW BEGIN
	UPDATE tb_barang SET stok= stok + NEW.jumlah_m
	WHERE nama_barang = NEW.nama_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_client`
--

CREATE TABLE `tb_client` (
  `id_client` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `nama_client` varchar(255) NOT NULL,
  `no_tlp` varchar(255) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_client`
--

INSERT INTO `tb_client` (`id_client`, `jenis_kelamin`, `alamat`, `nama_client`, `no_tlp`, `tanggal`) VALUES
('C00001', 'Laki-laki', 'Jl.Mampang Prapatan', 'Ahmad Randi', '087728128363', '2022-11-15'),
('C00002', 'Perempuan', 'Pancoran Barat', 'Bella', '1092310972', '2022-11-29');

-- --------------------------------------------------------

--
-- Stand-in structure for view `tb_detail_barang_trans`
-- (See below for the actual view)
--
CREATE TABLE `tb_detail_barang_trans` (
`id_barang` varchar(200)
,`nama_barang` varchar(200)
,`keterangan` varchar(200)
,`satuan` varchar(255)
,`stok` varchar(255)
,`harga_satuan` varchar(255)
,`jumlah_m` int(255)
,`tanggal_m` date
,`total_pemasukan` varchar(250)
,`jumlah_k` int(255)
,`tanggal_k` date
,`total_pengeluaran` varchar(255)
,`keuntungan` varchar(255)
);

-- --------------------------------------------------------

--
-- Table structure for table `tb_kategori`
--

CREATE TABLE `tb_kategori` (
  `idkategori` varchar(255) NOT NULL,
  `kategori_barang` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kategori`
--

INSERT INTO `tb_kategori` (`idkategori`, `kategori_barang`) VALUES
('K00001', 'Botol'),
('K00002', 'Bubuk');

-- --------------------------------------------------------

--
-- Table structure for table `tb_supplier`
--

CREATE TABLE `tb_supplier` (
  `id_supplier` varchar(255) NOT NULL,
  `nama_supplier` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `no_tlp` varchar(255) NOT NULL,
  `norek` varchar(255) NOT NULL,
  `bank` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_supplier`
--

INSERT INTO `tb_supplier` (`id_supplier`, `nama_supplier`, `alamat`, `no_tlp`, `norek`, `bank`, `email`, `tanggal`) VALUES
('S00001', 'Maju Mundur', 'Jl.Mampang', '28391261', '241233', 'BSI', 'majuengak@gmail.com', '2022-11-13'),
('S00002', 'Kpn Bangkrut', 'Jl.Pancoran', '0212237851', '834846', 'BRI', 'bangkrut@gmail.com', '2022-11-13');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`firstname`, `lastname`, `username`, `password`, `role`) VALUES
('Ahmad', 'Randi', 'randi', '123', 'Manajer'),
('Akmal', 'Akmal Aja', 'akmal', '123', 'Manajer'),
('aqrom', 'akmal', 'Aqrom', '123', 'Manajer'),
('Rizki', 'Afriansyah', 'rizki', '1234', 'Petugas');

-- --------------------------------------------------------

--
-- Structure for view `tb_detail_barang_trans`
--
DROP TABLE IF EXISTS `tb_detail_barang_trans`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tb_detail_barang_trans`  AS SELECT `tb_barang`.`id_barang` AS `id_barang`, `tb_barang`.`nama_barang` AS `nama_barang`, `tb_barang`.`keterangan` AS `keterangan`, `tb_barang`.`satuan` AS `satuan`, `tb_barang`.`stok` AS `stok`, `tb_barang_masuk`.`harga_satuan` AS `harga_satuan`, `tb_barang_masuk`.`jumlah_m` AS `jumlah_m`, `tb_barang_masuk`.`tanggal_m` AS `tanggal_m`, `tb_barang_masuk`.`total_pemasukan` AS `total_pemasukan`, `tb_barang_keluar`.`jumlah_k` AS `jumlah_k`, `tb_barang_keluar`.`tanggal_k` AS `tanggal_k`, `tb_barang_keluar`.`total_pengeluaran` AS `total_pengeluaran`, `tb_barang_keluar`.`keuntungan` AS `keuntungan` FROM ((`tb_barang` join `tb_barang_masuk` on(`tb_barang`.`id_barang` = `tb_barang_masuk`.`id_barang`)) join `tb_barang_keluar` on(`tb_barang`.`id_barang` = `tb_barang_keluar`.`id_barang`))  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tb_barang_keluar`
--
ALTER TABLE `tb_barang_keluar`
  ADD PRIMARY KEY (`id_bk`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_barang_2` (`id_barang`);

--
-- Indexes for table `tb_barang_masuk`
--
ALTER TABLE `tb_barang_masuk`
  ADD PRIMARY KEY (`id_bm`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indexes for table `tb_client`
--
ALTER TABLE `tb_client`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexes for table `tb_kategori`
--
ALTER TABLE `tb_kategori`
  ADD PRIMARY KEY (`idkategori`);

--
-- Indexes for table `tb_supplier`
--
ALTER TABLE `tb_supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`firstname`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_barang_keluar`
--
ALTER TABLE `tb_barang_keluar`
  ADD CONSTRAINT `tb_barang_keluar_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `tb_client` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_barang_keluar_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `tb_barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_barang_masuk`
--
ALTER TABLE `tb_barang_masuk`
  ADD CONSTRAINT `tb_barang_masuk_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `tb_barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_barang_masuk_ibfk_2` FOREIGN KEY (`id_supplier`) REFERENCES `tb_supplier` (`id_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
