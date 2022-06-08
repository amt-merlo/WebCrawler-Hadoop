<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="WikipediaScrapping._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <div class="jumbotron">
        <h1 class="text-center">Wikipedia WebScrapper</h1>
        <p class="lead" style="text-align: center; font-size: small">Databases II | Final Project</p>
    </div>

    <div >
        <div style="text-align: center" >
            <h2><strong>Menu</strong></h2>
            <p>
                <asp:Button ID="btnConsultasxPalabra" runat="server" Text="Search by word" OnClick="btnConsultasxPalabra_Click" />
            </p>
            <p>
                <asp:Button ID="btnConsultasxPagina" runat="server" Text="Search by webpage" OnClick="btnConsultasxPagina_Click" />
            </p>
            <p>&nbsp;</p>
        </div>
    </div>

</asp:Content>
