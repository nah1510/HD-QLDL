Public Class QuanDTO
    Private iMaQuan As Integer
    Private strTenQuan As String

    Public Sub New(iMaQuan As Integer, strTenQuan As String)
        Me.iMaQuan = iMaQuan
        Me.strTenQuan = strTenQuan

    End Sub

    Public Property MaQuan As Integer
        Get
            Return iMaQuan
        End Get
        Set(value As Integer)
            iMaQuan = value
        End Set
    End Property

    Public Property TenQuan As String
        Get
            Return strTenQuan
        End Get
        Set(value As String)
            strTenQuan = value
        End Set
    End Property


    Public Sub New()
    End Sub

End Class
