

Imports QLDLNuoc_BUS
Imports QLDLNuoc_DTO
Imports Utility

Public Class TiepNhanDLGUI
    Private hoSoDaiLyBus As HoSoDaiLyBUS
    Private loaiDaiLyBus As LoaiDaiLyBus
    Private quanBus As QuanBUS

    Private Sub btnThem_Click(sender As Object, e As EventArgs) Handles btnThem.Click

    End Sub

    Private Sub frmTiepNhanDaiLy_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        hoSoDaiLyBus = New HoSoDaiLyBUS
        loaiDaiLyBus = New LoaiDaiLyBus
        quanBus = New QuanBUS
        Format(tbDienThoai.Text, "###-###-####")
        Dim Result As Result
        'load danh sach loaiDaiLy
        Dim listLoaiDaiLy = New List(Of LoaiDaiLyDTO)
        Result = loaiDaiLyBus.selectAll(listLoaiDaiLy)
        If (Result.FlagResult = False) Then
            MessageBox.Show("Lấy danh sách Loại đại lý không thành công.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
            System.Console.WriteLine(Result.SystemMessage)
            Close()
            Return
        End If
        cbLoaiDaiLy.DataSource = New BindingSource(listLoaiDaiLy, String.Empty)
        cbLoaiDaiLy.DisplayMember = "TenLoaiDaiLy"
        cbLoaiDaiLy.ValueMember = "MaLoaiDaiLy"
        'load danh sach quan hợp lệ
        Dim listQuan = New List(Of QuanDTO)
        Result = quanBus.selectAvailableQuan(listQuan)
        If (Result.FlagResult = False) Then
            MessageBox.Show("Lấy danh sách quận không thành công.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
            System.Console.WriteLine(Result.SystemMessage)
            Close()
            Return
        End If
        cbQuan.DataSource = New BindingSource(listQuan, String.Empty)
        cbQuan.DisplayMember = "TenQuan"
        cbQuan.ValueMember = "MaQuan"
        Dim nextMaDaiLy = "1"
        Result = hoSoDaiLyBus.buildMaDaiLy(nextMaDaiLy)
        If (Result.FlagResult = False) Then
            MessageBox.Show("Lấy danh tự động mã Đại Lý không thành công.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
            System.Console.WriteLine(Result.SystemMessage)
            Me.Close()
            Return
        End If
        TBMDL.Text = nextMaDaiLy
        TBMDL.Enabled = False


    End Sub

    Private Sub TBMDL_TextChanged(sender As Object, e As EventArgs) Handles TBMDL.TextChanged

    End Sub
    Private Sub tbDienThoai_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles tbDienThoai.KeyPress

    End Sub
End Class