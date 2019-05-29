Public Class LoaiDaiLyDTO
    Private iMaLoaiDaiLy As Integer
    Private strTenLoaiDaiLy As String
    Private iNoToiDa As Integer
    Public Sub New()
    End Sub
    Public Sub New(iMaLoaiDaiLy As Integer, strTenLoaiDaiLy As String, iNoToiDa As Integer)
        Me.iMaLoaiDaiLy = iMaLoaiDaiLy
        Me.strTenLoaiDaiLy = strTenLoaiDaiLy
        Me.iNoToiDa = iNoToiDa
    End Sub
    Public Property MaLoaiDaiLy As Integer
        Get
            Return iMaLoaiDaiLy
        End Get
        Set(value As Integer)
            iMaLoaiDaiLy = value
        End Set
    End Property

    Public Property TenLoaiDaiLy As String
        Get
            Return strTenLoaiDaiLy
        End Get
        Set(value As String)
            strTenLoaiDaiLy = value
        End Set
    End Property

    Public Property NoToiDa As Integer
        Get
            Return iNoToiDa
        End Get
        Set(value As Integer)
            iNoToiDa = value
        End Set
    End Property
End Class
