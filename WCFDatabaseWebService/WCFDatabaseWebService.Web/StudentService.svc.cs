using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WCFDatabaseWebService.Web
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "StudentService" in code, svc and config file together.
    public class StudentService : IStudentService
    {

        DataClasses1DataContext dc = new DataClasses1DataContext(@"Data Source=.\SQLEXPRESS;AttachDbFilename=D:\MCA IV\Silverlight\WCFDatabaseWebService\WCFDatabaseWebService.Web\App_Data\Database1.mdf;Integrated Security=True;User Instance=True");

        public List<student> GetData()
        {
            var display = from record in dc.students
                          select record;

            return display.ToList();
        }

        public void InsertData(string name, string course, string fees)
        {
            student record = new student();
            record.name = name;
            record.fees = Convert.ToInt32(fees);
            record.course = course;
            dc.students.InsertOnSubmit(record);
            dc.SubmitChanges();
        }


        public void UpdateData(string id, string name, string course, string fees)
        {
            var update = (from row in dc.students
                         where row.id == Convert.ToInt32(id)
                         select row).SingleOrDefault();

            update.name = name;
            update.fees = Convert.ToInt32(fees);
            update.course = course;
            dc.SubmitChanges();
        }


        public void DeleteData(string id)
        {
            var delete = (from row in dc.students
                          where row.id == Convert.ToInt32(id)
                          select row).SingleOrDefault();

            dc.students.DeleteOnSubmit(delete);
            dc.SubmitChanges();
        }
    }
}
