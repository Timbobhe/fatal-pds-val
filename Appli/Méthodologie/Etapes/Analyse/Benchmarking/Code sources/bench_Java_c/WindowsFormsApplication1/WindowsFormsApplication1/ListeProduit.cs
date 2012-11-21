using System;
using System.Collections;
using System.Linq;
using System.Text;

namespace WindowsFormsApplication1
{
    class ListeProduit
    {
        private Hashtable tab;

        public ListeProduit()
        {
            tab = new Hashtable();
            
        }
        public void insert(Produit p)
        {
            tab.Add(p.Reference,p);
        }
         public Produit select(String r)
        {
            return (Produit)tab[r];
        }
    }
}
