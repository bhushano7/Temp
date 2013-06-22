using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WCFDatabaseWebService.Web
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IStudentService" in both code and config file together.
    [ServiceContract]
    public interface IStudentService
    {
        [OperationContract]
        List<student> GetData();

        [OperationContract]
        void InsertData(string name , string course, string fees);

        [OperationContract]
        void UpdateData(string id,string name, string course, string fees);

        [OperationContract]
        void DeleteData(string id);
    }
}
