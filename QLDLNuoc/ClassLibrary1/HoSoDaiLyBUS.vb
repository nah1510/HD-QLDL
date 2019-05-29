Imports QLDLNuoc_DAL
Imports QLDLNuoc_DTO
Imports Utility


Public Class HoSoDaiLyBUS
    Private daiLyDAL As HoSoDaiLyDAL
    Public Sub New()
        daiLyDAL = New HoSoDaiLyDAL()
    End Sub
    Public Sub New(connectionString As String)
        daiLyDAL = New HoSoDaiLyDAL(connectionString)
    End Sub
    Public Function insert(daiLy As HoSoDaiLyDTO) As Result
        '1. verify data here!!

        Return daiLyDAL.insert(daiLy)


        Return New Result(False)
    End Function
    Public Function update(daily As HoSoDaiLyDTO) As Result
        Return daiLyDAL.update(daily)
    End Function
    Public Function updateNo_byMaDL(daily As HoSoDaiLyDTO) As Result
        Return daiLyDAL.updateNo_byMaDL(daily)
    End Function
    Public Function delete(MaDaiLy As Integer) As Result
        Return daiLyDAL.delete(MaDaiLy)
    End Function
    Public Function getSoLuongDaiLyLonNhat(ByRef SoLuong As Integer) As Result
        Return daiLyDAL.getSoLuongDaiLyLonNhat(SoLuong)
    End Function
    Public Function selectAll(ByRef listLoaiDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL(listLoaiDaiLy)
    End Function



    Public Function selectALL_ByType(maLoaiDaiLy As Integer, ByRef listDL As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByType(maLoaiDaiLy, listDL)
    End Function
    Public Function selectALL_ByTen(TenDaiLy As String, ByRef listDL As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByTen(TenDaiLy, listDL)
    End Function
    Public Function selectALL_ByMaDaiLy(MaDaiLy As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByMaDaiLy(MaDaiLy, ListDaiLy)
    End Function
    Public Function selectALL_ByMaQuan(MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByMaQuan(MaQuan, ListDaiLy)
    End Function




    Public Function selectALL_ByMavaTen(MaDaiLy As Integer, TenDaiLy As String, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByMavaTen(MaDaiLy, TenDaiLy, ListDaiLy)
    End Function
    Public Function selectALL_ByTenvaMaLDL(TenDaiLy As String, MaLoaiDaiLy As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByTenvaMaLDL(TenDaiLy, MaLoaiDaiLy, ListDaiLy)
    End Function
    Public Function selectALL_ByTenvaMaQuan(TenDaiLy As String, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByTenvaMaQuan(TenDaiLy, MaQuan, ListDaiLy)
    End Function
    Public Function selectALL_ByMaLDLvaMaQuan(MaLoaiDaiLy As Integer, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByMaLDLvaMaQuan(MaLoaiDaiLy, MaQuan, ListDaiLy)
    End Function
    Public Function selectALL_ByMaDLvaMaLDL(MaDaiLy As Integer, MaLoaiDaiLy As String, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByMaDLvaMaLDL(MaDaiLy, MaLoaiDaiLy, ListDaiLy)
    End Function
    Public Function selectALL_ByMaDLvaMaQuan(MaDaiLy As Integer, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByMaDLvaMaQuan(MaDaiLy, MaQuan, ListDaiLy)
    End Function




    Public Function selectALL_ByMavaTenvaMaDL(MaDaiLy As Integer, TenDaiLy As String, MaLoaiDaiLy As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByMavaTenvaMaDL(MaDaiLy, TenDaiLy, MaLoaiDaiLy, ListDaiLy)
    End Function
    Public Function selectALL_ByMavaTenvaMaQuan(MaDaiLy As Integer, TenDaiLy As String, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByMavaTenvaMaQuan(MaDaiLy, TenDaiLy, MaQuan, ListDaiLy)
    End Function
    Public Function selectALL_ByMavaMaLoaivaMaQuan(MaDaiLy As Integer, MaLoaiDaiLy As Integer, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByMavaMaLoaivaMaQuan(MaDaiLy, MaLoaiDaiLy, MaQuan, ListDaiLy)
    End Function
    Public Function selectALL_ByTenvaMaLDLvaMaQuan(TenDaiLy As String, MaLoaiDaiLy As Integer, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_ByTenvaMaLDLvaMaQuan(TenDaiLy, MaLoaiDaiLy, MaQuan, ListDaiLy)
    End Function



    Public Function selectALL_Full(MaDaiLy As Integer, MaLoaiDaiLy As Integer, TenDaiLy As String, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Return daiLyDAL.selectALL_Full(MaDaiLy, MaLoaiDaiLy, TenDaiLy, MaQuan, ListDaiLy)
    End Function




    Public Function buildMaDaiLy(ByRef nextMaDaiLy As Integer) As Result
        Return daiLyDAL.buildMaDaiLy(nextMaDaiLy)
    End Function
    Public Function getTienNo_ByType(maDaiLy As Integer, ByRef NoCuaDaiLy As Integer) As Result
        Return daiLyDAL.getTienNo_ByType(maDaiLy, NoCuaDaiLy)
    End Function
    Public Function getLoai_ByType(maDaiLy As Integer, ByRef MaLoaiDaiLy As Integer) As Result
        Return daiLyDAL.getLoai_ByType(maDaiLy, MaLoaiDaiLy)
    End Function
    Public Function getTenDaiLy_ByType(MaDaiLy As Integer, ByRef TenDaiLy As String) As Result
        Return daiLyDAL.getTenDaiLy_ByType(MaDaiLy, TenDaiLy)
    End Function
    Public Function getDTvaDCvaEmailvaNoCuaDaiLy(maDaiLy As Integer, ByRef DienThoai As String, ByRef DiaChi As String, ByRef Email As String, ByRef NoCuaDaiLy As Integer) As Result
        Return daiLyDAL.getDTvaDCvaEmailvaNoCuaDaiLy(maDaiLy, DienThoai, DiaChi, Email, NoCuaDaiLy)
    End Function
End Class
