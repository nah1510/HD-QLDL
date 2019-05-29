Public Class HoSoDaiLyDTO
    Private iMaDaiLy As Integer
    Private strTenDaiLy As String
    Private iMaLoaiDaiLy As Integer
    Private strDienThoai As String
    Private strDiaChi As String
    Private iMaQuan As Integer
    Private dateNgayTiepNhan As DateTime
    Private strEmail As String
    Private iNoCuaDaiLy As Integer
    Public Sub New()
    End Sub
    Public Sub New(iMaDaiLy As Integer, strTenDaiLy As String, iMaLoaiDaiLy As Integer, strDienThoai As String, strDiaChi As String, iMaQuan As Integer, dateNgayTiepNhan As DateTime, strEmail As String, iNoCuaDaiLy As Integer)
        Me.iMaDaiLy = iMaDaiLy
        Me.iMaLoaiDaiLy = iMaLoaiDaiLy
        Me.iMaQuan = iMaQuan
        Me.iNoCuaDaiLy = iNoCuaDaiLy
        Me.strDiaChi = strDiaChi
        Me.strDienThoai = strDienThoai
        Me.strEmail = strEmail
        Me.strTenDaiLy = strTenDaiLy
        Me.dateNgayTiepNhan = dateNgayTiepNhan
    End Sub
    Public Sub New(iMaDaiLy As Integer, strTenDaiLy As String, iMaLoaiDaiLy As Integer, iNoCuaDaiLy As Integer)
        Me.iMaDaiLy = iMaDaiLy
        Me.iMaLoaiDaiLy = iMaLoaiDaiLy
        Me.iNoCuaDaiLy = iNoCuaDaiLy
        Me.strTenDaiLy = strTenDaiLy
    End Sub
    Public Property MaDaiLy As Integer
        Get
            Return iMaDaiLy
        End Get
        Set(value As Integer)
            iMaDaiLy = value
        End Set
    End Property

    Public Property TenDaiLy As String
        Get
            Return strTenDaiLy
        End Get
        Set(value As String)
            strTenDaiLy = value
        End Set
    End Property

    Public Property MaLoaiDaiLy As Integer
        Get
            Return iMaLoaiDaiLy
        End Get
        Set(value As Integer)
            iMaLoaiDaiLy = value
        End Set
    End Property

    Public Property DienThoai As String
        Get
            Return strDienThoai
        End Get
        Set(value As String)
            strDienThoai = value
        End Set
    End Property

    Public Property DiaChi As String
        Get
            Return strDiaChi
        End Get
        Set(value As String)
            strDiaChi = value
        End Set
    End Property

    Public Property MaQuan As Integer
        Get
            Return iMaQuan
        End Get
        Set(value As Integer)
            iMaQuan = value
        End Set
    End Property

    Public Property NgayTiepNhan As Date
        Get
            Return dateNgayTiepNhan
        End Get
        Set(value As Date)
            dateNgayTiepNhan = value
        End Set
    End Property

    Public Property Email As String
        Get
            Return strEmail
        End Get
        Set(value As String)
            strEmail = value
        End Set
    End Property

    Public Property NoCuaDaiLy As Integer
        Get
            Return iNoCuaDaiLy
        End Get
        Set(value As Integer)
            iNoCuaDaiLy = value
        End Set
    End Property
End Class
