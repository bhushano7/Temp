using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;

namespace WCFDatabaseWebService
{
    public partial class MainPage : UserControl
    {
        ServiceReferenceStudent.StudentServiceClient student;

        public MainPage()
        {
            student = new ServiceReferenceStudent.StudentServiceClient();
            InitializeComponent();
        }

        private void btnShow_Click(object sender, RoutedEventArgs e)
        {
            student.GetDataAsync();
            student.GetDataCompleted += new EventHandler<ServiceReferenceStudent.GetDataCompletedEventArgs>(student_GetDataCompleted);
        }

        void student_GetDataCompleted(object sender, ServiceReferenceStudent.GetDataCompletedEventArgs e)
        {
            dataGrid1.ItemsSource = e.Result;
        }

        private void btnInsert_Click(object sender, RoutedEventArgs e)
        {
            student.InsertDataAsync(txtName.Text, txtCourse.Text, txtFees.Text);
            btnShow_Click(sender, e);
        }
        
        private void btnUpdate_Click(object sender, RoutedEventArgs e)
        {
            student.UpdateDataAsync(txtId.Text, txtName.Text, txtCourse.Text, txtFees.Text);
            btnShow_Click(sender, e);
        }

        private void btnDelete_Click(object sender, RoutedEventArgs e)
        {
            student.DeleteDataAsync(txtId.Text);
            btnShow_Click(sender, e);
        }
    }
}
