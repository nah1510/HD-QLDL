Imports System.Configuration
Imports System.Data.SqlClient
Imports QLDLNuoc_DTO
Imports Utility

Public Class HoSoDaiLyDAL
    Private connectionString As String
    Dim cmd As New SqlCommand
    Dim da As New SqlDataAdapter
    Dim dr As SqlDataReader
    Dim ds As New DataSet
    Public Sub New()
        ' Read ConnectionString value from App.config file
        connectionString = ConfigurationManager.AppSettings("ConnectionString")
    End Sub
    Public Sub New(ConnectionString As String)
        Me.connectionString = ConnectionString
    End Sub

    Public Function buildMaDaiLy(ByRef nextMaDaiLy As Integer) As Result
        Dim MaOnDB As Integer
        Dim query As String = String.Empty
        query &= " SELECT IDENT_CURRENT('HOSODAILY')"
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
                            MaOnDB = Convert.ToInt32(reader.GetValue(0))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close() ' that bai!!!
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tự động Mã Đại Lý kế tiếp không thành công", ex.StackTrace)
                End Try
            End Using
        End Using




        query = String.Empty
        query &= "SELECT * FROM [HOSODAILY] where [MaDaiLy] = @MaDaiLy"
        'neu has row thi nextMshs = "SELECT IDENT_CURRENT('HOCSINH')" + 1
        'neu khong co row thì next Mshs = 1;
        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaOnDB)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        nextMaDaiLy = 1 + MaOnDB
                    Else
                        nextMaDaiLy = MaOnDB
                    End If
                Catch ex As Exception
                    conn.Close() ' that bai!!!
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tự động Mã Đại Lý kế tiếp không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function


    Public Function insert(daiLy As HoSoDaiLyDTO) As Result

        Dim query As String = String.Empty
        query &= "INSERT INTO [HOSODAILY] ( [TenDaiLy], [MaLoaiDaiLy], [DienThoai], [DiaChi],[MaQuan],[NgayTiepNhan],[Email],[NoCuaDaiLy])"
        query &= "VALUES (@TenDaiLy,@MaLoaiDaiLy,@DienThoai,@DiaChi,@MaQuan,@NgayTiepNhan,@Email,@NoCuaDaiLy)"


        Dim nextMaDaiLy = "1"
        buildMaDaiLy(nextMaDaiLy)
        daiLy.MaDaiLy = nextMaDaiLy

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query

                    .Parameters.AddWithValue("@TenDaiLy", daiLy.TenDaiLy)
                    .Parameters.AddWithValue("@MaLoaiDaiLy", daiLy.MaLoaiDaiLy)
                    .Parameters.AddWithValue("@DienThoai", daiLy.DienThoai)
                    .Parameters.AddWithValue("@DiaChi", daiLy.DiaChi)
                    .Parameters.AddWithValue("@MaQuan", daiLy.MaQuan)
                    .Parameters.AddWithValue("@NgayTiepNhan", daiLy.NgayTiepNhan)
                    .Parameters.AddWithValue("@Email", daiLy.Email)
                    .Parameters.AddWithValue("@NoCuaDaiLy", daiLy.NoCuaDaiLy)
                End With
                Try
                    conn.Open()
                    comm.ExecuteNonQuery()
                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Thêm thẻ Đại lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function update(dl As HoSoDaiLyDTO) As Result

        Dim query As String = String.Empty
        query &= " UPDATE [HOSODAILY] SET"
        query &= " [TenDaiLy] = @TenDaiLy "
        query &= " ,[MaLoaiDaiLy] = @MaLoaiDaiLy "
        query &= " ,[DienThoai] = @DienThoai "
        query &= " ,[DiaChi] = @DiaChi "
        query &= " ,[MaQuan] = @MaQuan "
        query &= " ,[NgayTiepNhan] = @NgayTiepNhan "
        query &= " ,[Email] = @Email "
        query &= " ,[NoCuaDaiLy] = @NoCuaDaiLy "
        query &= " WHERE "
        query &= " [MaDaiLy] = @MaDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", dl.MaDaiLy)
                    .Parameters.AddWithValue("@MaLoaiDaiLy", dl.MaLoaiDaiLy)
                    .Parameters.AddWithValue("@MaQuan", dl.MaQuan)
                    .Parameters.AddWithValue("@NgayTiepNhan", dl.NgayTiepNhan)
                    .Parameters.AddWithValue("@NoCuaDaiLy", dl.NoCuaDaiLy)
                    .Parameters.AddWithValue("@TenDaiLy", dl.TenDaiLy)
                    .Parameters.AddWithValue("@DienThoai", dl.DienThoai)
                    .Parameters.AddWithValue("@Email", dl.Email)
                    .Parameters.AddWithValue("@DiaChi", dl.DiaChi)

                End With
                Try
                    conn.Open()
                    comm.ExecuteNonQuery()
                Catch ex As Exception
                    Console.WriteLine(ex.StackTrace)
                    conn.Close()
                    ' them that bai!!!
                    Return New Result(False, "Cập nhật Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function updateNo_byMaDL(dl As HoSoDaiLyDTO) As Result
        Dim query As String = String.Empty
        query &= " UPDATE [HOSODAILY] SET"
        query &= " [NoCuaDaiLy] = @NoCuaDaiLy "
        query &= " WHERE "
        query &= " [MaDaiLy] = @MaDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", dl.MaDaiLy)
                    .Parameters.AddWithValue("@NoCuaDaiLy", dl.NoCuaDaiLy)

                End With
                Try
                    conn.Open()
                    comm.ExecuteNonQuery()
                Catch ex As Exception
                    Console.WriteLine(ex.StackTrace)
                    conn.Close()
                    ' them that bai!!!
                    Return New Result(False, "Cập nhật nợ không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function delete(MaDaiLy As String) As Result

        Dim query As String = String.Empty
        query &= " DELETE FROM [HoSoDaiLy] "
        query &= " WHERE "
        query &= " [MaDaiLy] = @MaDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                End With
                Try
                    conn.Open()
                    comm.ExecuteNonQuery()
                Catch ex As Exception
                    Console.WriteLine(ex.StackTrace)
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Xóa Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True)  ' thanh cong
    End Function
    Public Function selectALL(ByRef listDaiLy As List(Of HoSoDaiLyDTO)) As Result

        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "



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
                        listDaiLy.Clear()
                        While reader.Read()
                            listDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByType(MaLoaiDaiLy As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
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
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function getTienNo_ByType(MaDaiLy As Integer, ByRef NoCuaDaiLy As Integer) As Result
        Dim query As String = String.Empty
        query &= "SELECT [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                End With
                Try
                    conn.Open()
                    Dim sqlReader As SqlDataReader = comm.ExecuteReader()
                    While sqlReader.Read()
                        NoCuaDaiLy = sqlReader("NoCuaDaiLy")
                    End While


                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy Tiền Nợ theo Mã Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function getLoai_ByType(MaDaiLy As Integer, ByRef MaLoaiDaiLy As Integer) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaLoaiDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                End With
                Try
                    conn.Open()
                    Dim sqlReader As SqlDataReader = comm.ExecuteReader()
                    While sqlReader.Read()
                        MaLoaiDaiLy = sqlReader("MaLoaiDaiLy")
                    End While


                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy Mã Loại Đại Lý theo Mã Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function getSoLuongDaiLyLonNhat(ByRef SoLuong As Integer) As Result
        Dim query As String = String.Empty
        query &= "SELECT TOP 1 COUNT (*) AS NO "
        query &= "FROM [HoSoDaiLy] AS DL, [QUAN] AS Q "
        query &= "WHERE [Q].[MaQuan]= [DL].[MaQuan]"
        query &= "GROUP BY [Q].[MAQUAN]"
        query &= "ORDER BY NO DESC"

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
                        SoLuong = sqlReader("NO")
                    End While


                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy Mã Loại Đại Lý theo Mã Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function getTenDaiLy_ByType(MaDaiLy As Integer, ByRef TenDaiLy As String) As Result
        Dim query As String = String.Empty
        query &= "SELECT [TenDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                End With
                Try
                    conn.Open()
                    Dim sqlReader As SqlDataReader = comm.ExecuteReader()
                    While sqlReader.Read()
                        TenDaiLy = sqlReader("TenDaiLy")
                    End While


                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy Tên Đại Lý theo Mã Đại Lý không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMaDaiLy(MaDaiLy As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMavaTen(MaDaiLy As Integer, TenDaiLy As String, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy AND [TenDaiLy] = @TenDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                    .Parameters.AddWithValue("@TenDaiLy", TenDaiLy)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMavaTenvaMaDL(MaDaiLy As Integer, TenDaiLy As String, MaLoaiDaiLy As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy AND [TenDaiLy] = @TenDaiLy AND [MaLoaiDaiLy] =@MaLoaiDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                    .Parameters.AddWithValue("@TenDaiLy", TenDaiLy)
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDaiLy)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMaDLvaMaLDL(MaDaiLy As Integer, MaLoaiDaiLy As String, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy AND [MaLoaiDaiLy] = @MaLoaiDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDaiLy)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMaDLvaMaQuan(MaDaiLy As Integer, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy AND [MaQuan] = @MaQuan "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                    .Parameters.AddWithValue("@MaQuan", MaQuan)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMavaTenvaMaQuan(MaDaiLy As Integer, TenDaiLy As String, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy AND [TenDaiLy] = @TenDaiLy AND [MaQuan] = @MaQuan "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                    .Parameters.AddWithValue("@TenDaiLy", TenDaiLy)
                    .Parameters.AddWithValue("@MaQuan", MaQuan)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMavaMaLoaivaMaQuan(MaDaiLy As Integer, MaLoaiDaiLy As Integer, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy AND [MaLoaiDaiLy] = @MaLoaiDaiLy AND [MaQuan] = @MaQuan "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDaiLy)
                    .Parameters.AddWithValue("@MaQuan", MaQuan)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_Full(MaDaiLy As Integer, MaLoaiDaiLy As Integer, TenDaiLy As String, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy] = @MaDaiLy AND [MaLoaiDaiLy] = @MaLoaiDaiLy AND [TenDaiLy] = @TenDaiLy AND [MaQuan] = @MaQuan "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", MaDaiLy)
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDaiLy)
                    .Parameters.AddWithValue("@TenDaiLy", TenDaiLy)
                    .Parameters.AddWithValue("@MaQuan", MaQuan)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByTen(TenDaiLy As String, ByRef listDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [TenDaiLy] = @TenDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@TenDaiLy", TenDaiLy)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        listDaiLy.Clear()
                        While reader.Read()
                            listDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMaQuan(MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaQuan] = @MaQuan "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaQuan", MaQuan)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByTenvaMaLDL(TenDaiLy As String, MaLoaiDaiLy As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [TenDaiLy] = @TenDaiLy AND [MaLoaiDaiLy]= @MaLoaiDaiLy "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@TenDaiLy", TenDaiLy)
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDaiLy)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByTenvaMaQuan(TenDaiLy As String, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [TenDaiLy] = @TenDaiLy AND [MaQuan]= @MaQuan "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@TenDaiLy", TenDaiLy)
                    .Parameters.AddWithValue("@MaQuan", MaQuan)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByMaLDLvaMaQuan(MaLoaiDaiLy As Integer, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaLoaiDaiLy] = @MaLoaiDaiLy AND [MaQuan]= @MaQuan "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDaiLy)
                    .Parameters.AddWithValue("@MaQuan", MaQuan)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function selectALL_ByTenvaMaLDLvaMaQuan(TenDaiLy As String, MaLoaiDaiLy As Integer, MaQuan As Integer, ByRef ListDaiLy As List(Of HoSoDaiLyDTO)) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [MaLoaiDaiLy], [TenDaiLy], [DienThoai],[DiaChi],[MaQuan],[NgayTiepNhan],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [TenDaiLy] = @TenDaiLy AND [MaLoaiDaiLy]=@MaLoaiDaiLy AND [MaQuan]= @MaQuan "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@TenDaiLy", TenDaiLy)
                    .Parameters.AddWithValue("@MaLoaiDaiLy", MaLoaiDaiLy)
                    .Parameters.AddWithValue("@MaQuan", MaQuan)
                End With
                Try
                    conn.Open()
                    Dim reader As SqlDataReader
                    reader = comm.ExecuteReader()
                    If reader.HasRows = True Then
                        ListDaiLy.Clear()
                        While reader.Read()
                            ListDaiLy.Add(New HoSoDaiLyDTO(reader("MaDaiLy"), reader("TenDaiLy"), reader("MaLoaiDaiLy"), reader("DienThoai"), reader("DiaChi"), reader("MaQuan"), reader("NgayTiepNhan"), reader("Email"), reader("NoCuaDaiLy")))
                        End While
                    End If

                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy tất cả Đại Lý theo Loại không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
    Public Function getDTvaDCvaEmailvaNoCuaDaiLy(maDaiLy As Integer, ByRef DienThoai As String, ByRef DiaChi As String, ByRef Email As String, ByRef NoCuaDaiLy As Integer) As Result
        Dim query As String = String.Empty
        query &= "SELECT [MaDaiLy], [DienThoai], [DiaChi],[Email], [NoCuaDaiLy] "
        query &= "FROM [HoSoDaiLy] "
        query &= "WHERE [MaDaiLy]=@MaDaiLy  "

        Using conn As New SqlConnection(connectionString)
            Using comm As New SqlCommand()
                With comm
                    .Connection = conn
                    .CommandType = CommandType.Text
                    .CommandText = query
                    .Parameters.AddWithValue("@MaDaiLy", maDaiLy)
                End With
                Try
                    conn.Open()
                    Dim sqlReader As SqlDataReader = comm.ExecuteReader()
                    While sqlReader.Read()
                        DienThoai = sqlReader("DienThoai")
                        DiaChi = sqlReader("DiaChi")
                        Email = sqlReader("Email")
                        NoCuaDaiLy = sqlReader("NoCuaDaiLy")
                    End While


                Catch ex As Exception
                    conn.Close()
                    System.Console.WriteLine(ex.StackTrace)
                    Return New Result(False, "Lấy Thông Tin không thành công", ex.StackTrace)
                End Try
            End Using
        End Using
        Return New Result(True) ' thanh cong
    End Function
End Class
