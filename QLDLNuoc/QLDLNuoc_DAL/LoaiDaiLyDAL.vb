Imports System.Configuration
Imports System.Data.SqlClient
Imports QLDLNuoc_DTO
Imports Utility


Public Class LoaiDaiLyDAL
    Private connectionString As String
    Public Sub New()
        ' Read ConnectionString value from App.config file
        connectionString = ConfigurationManager.AppSettings("ConnectionString")

    End Sub
    Public Sub New(ConnectionString As String)
        Me.connectionString = ConnectionString
    End Sub
    Public Function buildMaLoaiDaiLy(ByRef nextMaLoaiDaiLy As Integer) As Result
        Dim MaLoaiDLonDB As Integer
        Dim query As String = String.Empty
        query &= " SELECT IDENT_CURRENT('LOAIDAILY')"
        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        While reader.Read()
                            MaLoaiDLonDB = Convert.ToInt32(reader.GetValue(0))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close() ' that bai!!!
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tự động Mã Loại Đại Lý kế tiếp không thành công", ex.StackTrace)
                End Try
            End Using
        End Using




        query = String.Empty
        query &= "SELECT * FROM [LOAIDAILY] where [MaLoaiDaiLy] = @MaLoaiDaiLy"
        'neu has row thi nextMshs = "SELECT IDENT_CURRENT('HOCSINH')" + 1
        'neu khong co row thì next Mshs = 1;
        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDLonDB)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        nextMaLoaiDaiLy = 1 + MaLoaiDLonDB
                    Else
                        nextMaLoaiDaiLy = MaLoaiDLonDB
                    End If
                Catch ex As Exception
                    conn.Close() ' that bai!!!
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tự động Mã Loại Đại Lý kế tiếp không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function insert(LoaiDaiLy As LoaiDaiLyDTO) As Result

        Dim query As String = String.Empty
        query &= "INSERT INTO [LOAIDAILY] (  [TenLoaiDaiLy], [NoToiDa])"
        query &= "VALUES (@TenLoaiDaiLy,@NoToiDa)"


        Dim nextMaLoaiDaiLy = "1"
        buildMaLoaiDaiLy(nextMaLoaiDaiLy)
        LoaiDaiLy.MaLoaiDaiLy = nextMaLoaiDaiLy

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@TenLoaiDaiLy", LoaiDaiLy.TenLoaiDaiLy)
                    .Parameters.AddWithValue("@NoToiDa", LoaiDaiLy.NoToiDa)

                End With
                Try
                    conn.Open()
                    comm.ExecuteNonQuery()
                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Thêm Loại Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function update(mldl As LoaiDaiLyDTO) As Result

        Dim query As String = String.Empty
        query &= " UPDATE [LOAIDAILY] SET"
        query &= " [TenLoaiDaiLy] = @TenLoaiDaiLy "
        query &= " ,[NoToiDa] = @NoToiDa "
        query &= " WHERE "
        query &= " [MaLoaiDaiLy] = @MaLoaiDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaLoaiDaiLy", mldl.MaLoaiDaiLy)
                    .Parameters.AddWithValue("@TenLoaiDaiLy", mldl.TenLoaiDaiLy)
                    .Parameters.AddWithValue("@NoToiDa", mldl.NoToiDa)
                End With
                Try
                    conn.Open()
                    comm.ExecuteNonQuery()
                Catch ex As Exception
                    Console.WriteLine(ex.StackTrace)
                    conn.Close()
                    ' them that bai!!!
                    Return New Result(False, "Cập nhật Loại Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function delete(MaLoaiDaiLy As Integer) As Result

        Dim query As String = String.Empty
        query &= " DELETE FROM [LOAIDAILY] "
        query &= " WHERE "
        query &= " [MaLoaiDaiLy] = @MaLoaiDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDaiLy)
                End With
                Try
                    conn.Open()
                    comm.ExecuteNonQuery()
                Catch ex As Exception
                    Console.WriteLine(ex.StackTrace)
                    conn.Close()
                    ' them that bai!!!
                    Return New Result(False, "Xóa Loại Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL(ByRef listLoaiDaiLy As List(Of LoaiDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaLoaiDaiLy], [TenLoaiDaiLy], [NoToiDa]"
        query &= "FROM [LOAIDAILY]"
        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        listLoaiDaiLy.Clear()
                        While reader.Read()
                            listLoaiDaiLy.Add(New LoaiDaiLyDTO(reader("MaLoaiDaiLy"), reader("TenLoaiDaiLy"), reader("NoToiDa")))
                        End While
                    End If
                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả loại đại lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMaLoaiDaiLy(iMaLoaiDaiLy As Integer, ByRef listLoaiDaiLy As List(Of LoaiDaiLyDTO)) As Result

        Dim query As String = String.Empty
        query &= " SELECT [MaLoaiDaiLy], [TenLoaiDaiLy], [NoToiDa]"
        query &= " FROM [LOAIDAILY]"
        query &= " WHERE "
        query &= " [MaLoaiDaiLy] = @MaLoaiDaiLy"


        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaLoaiDaiLy", iMaLoaiDaiLy)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        listLoaiDaiLy.Clear()
                        While reader.Read()
                            listLoaiDaiLy.Add(New LoaiDaiLyDTO(reader("MaLoaiDaiLy"), reader("TenLoaiDaiLy"), reader("NoToiDa")))
                        End While
                    End If
                Catch ex As Exception
                    Console.WriteLine(ex.StackTrace)
                    conn.Close()
                    ' them that bai!!!
                    Return New Result(False, "Lấy tất cả Loại Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function getNoToiDa_ByType(MaLoaiDaiLy As Integer, ByRef NoToiDa As Integer) As Result
        Dim query As String = String.Empty
        query &= "SELECT [NoToiDa] "
        query &= "FROM [LOAIDAILY] "
        query &= "WHERE [MaLoaiDaiLy] = @MaLoaiDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDaiLy)
                End With
                Try
                    conn.Open()
                    Dim sqlReader As SqlDataReader = comm.ExecuteReader()
                    While sqlReader.Read()
                        NoToiDa = sqlReader("NoToiDa")
                    End While


                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy Nợ Tối Đa theo Mã Loại Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function countLDL(ByRef SoLuong As Integer) As Result
        Dim query As String = String.Empty
        query &= "SELECT COUNT ([MaLoaiDaiLy])"
        query &= "As [SoLuong] "
        query &= "FROM [LOAIDAILY] "


        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query

                End With
                Try
                    conn.Open()
                    Dim sqlReader As SqlDataReader = comm.ExecuteReader()
                    While sqlReader.Read()
                        SoLuong = sqlReader("SoLuong")
                    End While


                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy Loại Đại Lý Tối Đa theo Mã Loại Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function

End Class
