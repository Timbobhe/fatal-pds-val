using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WindowsFormsApplication1
{
    class Produit
    {
        public Produit()
        { 
        }
        private String reference;

        public String Reference
        {
            get { return reference; }
            set { reference = value; }
        }
        private String desig;

        public String Desig
        {
            get { return desig; }
            set { desig = value; }
        }
        private double prix;

        public double Prix
        {
            get { return prix; }
            set { prix = value; }
        }
        private double q;

        public double Q
        {
            get { return q; }
            set { q = value; }
        }


    }
}
