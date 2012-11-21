using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
           long starttick = System.Environment.TickCount;



            ListeProduit l = new ListeProduit();
            for(int i=0;i<100000;i++)
            {
                Produit p = new Produit();
                p.Reference = "C0" + i;
                p.Desig = "Clavier";
                p.Prix = 100;
                p.Q = 10;

                l.insert(p);
            }
            long endtick = System.Environment.TickCount;
            label2.Text= endtick - starttick+"";
           
        }

        private void button2_Click(object sender, EventArgs e)
        {
            ListeProduit l = new ListeProduit();
            for (int i = 0; i < 100000; i++)
            {
                Produit p = new Produit();
                p.Reference = "C0" + i;
                p.Desig = "Clavier";
                p.Prix = 100;
                p.Q = 10;

                l.insert(p);
            }
            long starttick = System.Environment.TickCount;

            l.select("C099999");

           
            long endtick = System.Environment.TickCount;
            label2.Text = endtick - starttick + "";
        }
    }
}
