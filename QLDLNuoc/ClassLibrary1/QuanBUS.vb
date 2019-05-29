Imports QLDLNuoc_DAL
Imports QLDLNuoc_DTO
Imports Utility



Public Class QuanBUS
    Private quanDAL As QuanDAL
    Public Sub New()
        quanDAL = New QuanDAL()
    End Sub
    Public Sub New(connectionString As String)
        quanDAL = New QuanDAL(connectionString)
    End Sub
    Public Function insert(Quan As QuanDTO) As Result
        '1. verify data here!!

        '2. insert to DB
        Return quanDAL.insert(Quan)
        Return New Result(False)

    End Function
    Public Function update(Quan As QuanDTO) As Result
        '1. verify data here!!

        '2. insert to DB
        Return quanDAL.update(Quan)
    End Function
    Public Function delete(Quan As Integer) As Result
        '1. verify data here!!

        '2. insert to DB
        Return quanDAL.delete(Quan)
    End Function
    Public Function selectAvailableQuan(ByRef listQuan As List(Of QuanDTO)) As Result

        Return quanDAL.selectAvailableQuan(listQuan)
    End Function
    Public Function selectALL(ByRef listQuan As List(Of QuanDTO)) As Result

        Return quanDAL.selectALL(listQuan)
    End Function
    Public Function selectALL_ByMaQuan(iMaQuan As Integer, ByRef listQuan As List(Of QuanDTO)) As Result
        '1. verify data here!!

        '2. insert to DB
        Return quanDAL.selectALL_ByMaQuan(iMaQuan, listQuan)
    End Function
    Public Function buildMaQuan(ByRef nextMaQuan As Integer) As Result
        Return quanDAL.buildMaQuan(nextMaQuan)
    End Function
    Public Function countQU(ByRef SoLuong As Integer) As Result
        Return quanDAL.countQU(SoLuong)
    End Function
End Class
