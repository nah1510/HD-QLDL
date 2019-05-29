<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmMain
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
        Me.btnTNDL = New System.Windows.Forms.Button()
        Me.Button2 = New System.Windows.Forms.Button()
        Me.Button3 = New System.Windows.Forms.Button()
        Me.btnQLDL = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'btnTNDL
        '
        Me.btnTNDL.Location = New System.Drawing.Point(84, 72)
        Me.btnTNDL.Name = "btnTNDL"
        Me.btnTNDL.Size = New System.Drawing.Size(105, 41)
        Me.btnTNDL.TabIndex = 0
        Me.btnTNDL.Text = "Tiếp nhận đại lý"
        Me.btnTNDL.UseVisualStyleBackColor = True
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(339, 72)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(105, 41)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Hàng hóa"
        Me.Button2.UseVisualStyleBackColor = True
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(84, 250)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(105, 41)
        Me.Button3.TabIndex = 2
        Me.Button3.Text = "Phiếu xuất"
        Me.Button3.UseVisualStyleBackColor = True
        '
        'btnQLDL
        '
        Me.btnQLDL.Location = New System.Drawing.Point(84, 165)
        Me.btnQLDL.Name = "btnQLDL"
        Me.btnQLDL.Size = New System.Drawing.Size(105, 41)
        Me.btnQLDL.TabIndex = 3
        Me.btnQLDL.Text = "Quản lý đại lý"
        Me.btnQLDL.UseVisualStyleBackColor = True
        '
        'frmMain
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(585, 450)
        Me.Controls.Add(Me.btnQLDL)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.btnTNDL)
        Me.Name = "frmMain"
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents btnTNDL As Button
    Friend WithEvents Button2 As Button
    Friend WithEvents Button3 As Button
    Friend WithEvents btnQLDL As Button
End Class
