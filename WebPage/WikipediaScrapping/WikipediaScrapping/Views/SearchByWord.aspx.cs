using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WikipediaScrapping.Views
{
    public partial class SearchByWord : System.Web.UI.Page
    {
        MySqlConnection myConn;
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        public void conectar()
        {
            String server = "localhost";
            String port = "3309";
            String user = "root";
            String pwd = "1234";
            String database = "wikipedia";
            String cadenaConexion = "server=" + server + ";port=" + port + ";user=" + user + ";pwd=" + pwd + ";database=" + database + ";SslMode=none ;AllowPublicKeyRetrieval=true";

            try
            {
                myConn = new MySqlConnection(cadenaConexion);
                myConn.Open();
                Console.WriteLine("Succesfully :) yaaaas");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        public void llenarTablas()
        {

        }
    }
}