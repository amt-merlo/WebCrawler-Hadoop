using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WikipediaScrapping.Views
{
    public partial class UniquePage : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnViewAll_Click(object sender, EventArgs e)
        {
            Response.Redirect("Views/SearchByPage.aspx");
        }
    }
}