<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class TiepNhanDLGUI
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label10 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label8 = New System.Windows.Forms.Label()
        Me.Label9 = New System.Windows.Forms.Label()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.cbLoaiDaiLy = New System.Windows.Forms.ComboBox()
        Me.tbDiaChi = New System.Windows.Forms.TextBox()
        Me.dtpNgayTiepNhan = New System.Windows.Forms.DateTimePicker()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.tbDienThoai = New System.Windows.Forms.TextBox()
        Me.tbTen = New System.Windows.Forms.TextBox()
        Me.cbQuan = New System.Windows.Forms.ComboBox()
        Me.tbEmail = New System.Windows.Forms.TextBox()
        Me.TBNDL = New System.Windows.Forms.TextBox()
        Me.btnThem = New System.Windows.Forms.Button()
        Me.TBMDL = New System.Windows.Forms.TextBox()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Microsoft Sans Serif", 18.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.Label1.Location = New System.Drawing.Point(272, 61)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(214, 29)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "Tiếp Nhận Đại Lý"
        '
        'Label10
        '
        Me.Label10.AutoSize = True
        Me.Label10.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label10.Location = New System.Drawing.Point(74, 105)
        Me.Label10.Margin = New System.Windows.Forms.Padding(2, 0, 2, 0)
        Me.Label10.Name = "Label10"
        Me.Label10.Size = New System.Drawing.Size(88, 20)
        Me.Label10.TabIndex = 20
        Me.Label10.Text = "Mã Đại Lý"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.Label2.Location = New System.Drawing.Point(113, 140)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(49, 20)
        Me.Label2.TabIndex = 21
        Me.Label2.Text = "Tên: "
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.Label3.Location = New System.Drawing.Point(66, 187)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(96, 20)
        Me.Label3.TabIndex = 22
        Me.Label3.Text = "Điện thoại:"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.Label4.Location = New System.Drawing.Point(100, 234)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(62, 20)
        Me.Label4.TabIndex = 23
        Me.Label4.Text = "Quận: "
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.Label8.Location = New System.Drawing.Point(99, 275)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(63, 20)
        Me.Label8.TabIndex = 24
        Me.Label8.Text = "Email: "
        '
        'Label9
        '
        Me.Label9.AutoSize = True
        Me.Label9.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label9.Location = New System.Drawing.Point(85, 327)
        Me.Label9.Margin = New System.Windows.Forms.Padding(2, 0, 2, 0)
        Me.Label9.Name = "Label9"
        Me.Label9.Size = New System.Drawing.Size(77, 20)
        Me.Label9.TabIndex = 25
        Me.Label9.Text = "Nợ đại lý"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.Label5.Location = New System.Drawing.Point(511, 105)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(94, 20)
        Me.Label5.TabIndex = 26
        Me.Label5.Text = "Loại đại lý:"
        '
        'cbLoaiDaiLy
        '
        Me.cbLoaiDaiLy.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.cbLoaiDaiLy.FormattingEnabled = True
        Me.cbLoaiDaiLy.Location = New System.Drawing.Point(611, 101)
        Me.cbLoaiDaiLy.Name = "cbLoaiDaiLy"
        Me.cbLoaiDaiLy.Size = New System.Drawing.Size(225, 24)
        Me.cbLoaiDaiLy.TabIndex = 27
        '
        'tbDiaChi
        '
        Me.tbDiaChi.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.tbDiaChi.Location = New System.Drawing.Point(611, 163)
        Me.tbDiaChi.Name = "tbDiaChi"
        Me.tbDiaChi.Size = New System.Drawing.Size(225, 22)
        Me.tbDiaChi.TabIndex = 28
        '
        'dtpNgayTiepNhan
        '
        Me.dtpNgayTiepNhan.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.dtpNgayTiepNhan.Location = New System.Drawing.Point(611, 232)
        Me.dtpNgayTiepNhan.Name = "dtpNgayTiepNhan"
        Me.dtpNgayTiepNhan.Size = New System.Drawing.Size(225, 22)
        Me.dtpNgayTiepNhan.TabIndex = 29
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.Label7.Location = New System.Drawing.Point(471, 234)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(134, 20)
        Me.Label7.TabIndex = 30
        Me.Label7.Text = "Ngày tiếp nhận:"
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.Label6.Location = New System.Drawing.Point(511, 163)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(69, 20)
        Me.Label6.TabIndex = 31
        Me.Label6.Text = "Địa chỉ:"
        '
        'tbDienThoai
        '
        Me.tbDienThoai.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.tbDienThoai.Location = New System.Drawing.Point(213, 185)
        Me.tbDienThoai.Name = "tbDienThoai"
        Me.tbDienThoai.Size = New System.Drawing.Size(225, 22)
        Me.tbDienThoai.TabIndex = 32
        '
        'tbTen
        '
        Me.tbTen.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.tbTen.Location = New System.Drawing.Point(213, 138)
        Me.tbTen.Name = "tbTen"
        Me.tbTen.Size = New System.Drawing.Size(225, 22)
        Me.tbTen.TabIndex = 33
        '
        'cbQuan
        '
        Me.cbQuan.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.cbQuan.FormattingEnabled = True
        Me.cbQuan.Location = New System.Drawing.Point(213, 234)
        Me.cbQuan.Name = "cbQuan"
        Me.cbQuan.Size = New System.Drawing.Size(225, 24)
        Me.cbQuan.TabIndex = 34
        '
        'tbEmail
        '
        Me.tbEmail.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.tbEmail.Location = New System.Drawing.Point(213, 275)
        Me.tbEmail.Name = "tbEmail"
        Me.tbEmail.Size = New System.Drawing.Size(225, 22)
        Me.tbEmail.TabIndex = 35
        '
        'TBNDL
        '
        Me.TBNDL.Location = New System.Drawing.Point(213, 329)
        Me.TBNDL.Margin = New System.Windows.Forms.Padding(2)
        Me.TBNDL.Name = "TBNDL"
        Me.TBNDL.Size = New System.Drawing.Size(225, 20)
        Me.TBNDL.TabIndex = 36
        '
        'btnThem
        '
        Me.btnThem.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(163, Byte))
        Me.btnThem.Location = New System.Drawing.Point(620, 317)
        Me.btnThem.Name = "btnThem"
        Me.btnThem.Size = New System.Drawing.Size(171, 38)
        Me.btnThem.TabIndex = 37
        Me.btnThem.Text = "Thêm"
        Me.btnThem.UseVisualStyleBackColor = True
        '
        'TBMDL
        '
        Me.TBMDL.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.2!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.TBMDL.Location = New System.Drawing.Point(213, 100)
        Me.TBMDL.Margin = New System.Windows.Forms.Padding(2)
        Me.TBMDL.Name = "TBMDL"
        Me.TBMDL.Size = New System.Drawing.Size(225, 23)
        Me.TBMDL.TabIndex = 38
        '
        'TiepNhanDLGUI
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(1095, 450)
        Me.Controls.Add(Me.TBMDL)
        Me.Controls.Add(Me.btnThem)
        Me.Controls.Add(Me.TBNDL)
        Me.Controls.Add(Me.tbEmail)
        Me.Controls.Add(Me.cbQuan)
        Me.Controls.Add(Me.tbTen)
        Me.Controls.Add(Me.tbDienThoai)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.dtpNgayTiepNhan)
        Me.Controls.Add(Me.tbDiaChi)
        Me.Controls.Add(Me.cbLoaiDaiLy)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label9)
        Me.Controls.Add(Me.Label8)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label10)
        Me.Controls.Add(Me.Label1)
        Me.Name = "TiepNhanDLGUI"
        Me.Text = "DaiLyGui"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents Label10 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents Label4 As Label
    Friend WithEvents Label8 As Label
    Friend WithEvents Label9 As Label
    Friend WithEvents Label5 As Label
    Friend WithEvents cbLoaiDaiLy As ComboBox
    Friend WithEvents tbDiaChi As TextBox
    Friend WithEvents dtpNgayTiepNhan As DateTimePicker
    Friend WithEvents Label7 As Label
    Friend WithEvents Label6 As Label
    Friend WithEvents tbDienThoai As TextBox
    Friend WithEvents tbTen As TextBox
    Friend WithEvents cbQuan As ComboBox
    Friend WithEvents tbEmail As TextBox
    Friend WithEvents TBNDL As TextBox
    Friend WithEvents btnThem As Button
    Friend WithEvents TBMDL As TextBox
End Class
