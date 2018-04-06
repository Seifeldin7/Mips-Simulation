
package guim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class GuiM extends JFrame{
    private javax.swing.JTextField offset;
    private javax.swing.JComboBox<String> op1;
    private javax.swing.JComboBox<String> reg[]= new JComboBox[3];
    private String operation;
    private String regsrc;
    private String regtarget;
    private String regdst;
    private int number;
    private JButton ok;
    private JTextArea program;
    public GuiM(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        Container c= this.getContentPane();
        c.setLayout(null);
        program =new JTextArea();
        program.setBounds(150,50,500,100);
        c.add(program);
         offset =new JTextField();
        offset.setBounds(500,200,100,22);
        c.add(offset);
        ok = new JButton("OK");
        ok.setBounds(600, 200,100, 20);
        c.add(ok);
        
        
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                operation = (String)op1.getSelectedItem();
                regsrc=(String)reg[0].getSelectedItem();
                regtarget=(String)reg[1].getSelectedItem();
                regdst=(String)reg[2].getSelectedItem();
                if(offset.isEnabled())
                number = Integer.parseInt(offset.getText());
                if(((String)op1.getSelectedItem()).equals("lw")||((String)op1.getSelectedItem()).equals("sw")||((String)op1.getSelectedItem()).equals("sb")||((String)op1.getSelectedItem()).equals("lb"))
                program.setText(program.getText()+(String)op1.getSelectedItem()+" "+(String)reg[0].getSelectedItem()+","+offset.getText()+"("+(String)reg[1].getSelectedItem()+")\n");
                else if (((String)op1.getSelectedItem()).equals("addi")||((String)op1.getSelectedItem()).equals("sll"))
                 program.setText(program.getText()+(String)op1.getSelectedItem()+" "+(String)reg[0].getSelectedItem()+","+(String)reg[1].getSelectedItem()+","+offset.getText()+"\n");
                else
                program.setText(program.getText()+(String)op1.getSelectedItem()+" "+(String)reg[0].getSelectedItem()+","+(String)reg[1].getSelectedItem()+","+(String)reg[2].getSelectedItem()+"\n");
            }
        });
        
        
        op1 = new JComboBox();
        op1.addItem("add");
        op1.addItem("addi");
        op1.addItem("slti");
        op1.addItem("lw");
        op1.addItem("sw");
        op1.addItem("sb");
        op1.addItem("slt");
        op1.addItem("lb");
        op1.addItem("lbu");
        op1.addItem("beq");
        op1.addItem("j");
        op1.addItem("sll");
        op1.addItem("nor");
        op1.addItem("jal");
        op1.addItem("jr");
        op1.setSelectedItem(null);
        op1.setBounds(100, 200, 100, 20);
         this.add(op1);
        op1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie) {
          if(((String)op1.getSelectedItem()).equals("lw")||((String)op1.getSelectedItem()).equals("sw")||((String)op1.getSelectedItem()).equals("sb")||
                  ((String)op1.getSelectedItem()).equals("lb")||((String)op1.getSelectedItem()).equals("addi")||((String)op1.getSelectedItem()).equals("sll")){
              reg[2].setEnabled(false);
              reg[0].setEnabled(true);
              reg[1].setEnabled(true);
              offset.setEnabled(true);
            }
            else if (((String)op1.getSelectedItem()).equals("j")){
               for(int i=0;i<3;i++){
                   reg[i].setEnabled(false);
               }
            }
            else{
                for(int i=0;i<3;i++)
                   reg[i].setEnabled(true);
               offset.setEnabled(false);
            }
        }
        });
        
        for(int i=0;i<3;i++){
        reg[i] = new JComboBox();
        reg[i].addItem("$zer0");
        reg[i].addItem("$at");
        reg[i].addItem("$v0");
        reg[i].addItem("$v1");
        reg[i].addItem("$a0");
        reg[i].addItem("$a1");
        reg[i].addItem("$a2");
        reg[i].addItem("$a3");
        reg[i].addItem("$t0");
        reg[i].addItem("$t1");
        reg[i].addItem("$t2");
        reg[i].addItem("$t3");
        reg[i].addItem("$t4");
        reg[i].addItem("$t5");
        reg[i].addItem("$t6");
        reg[i].addItem("$t7");
        reg[i].addItem("$s0");
        reg[i].addItem("$s1");
        reg[i].addItem("$s2");
        reg[i].addItem("$s3");
        reg[i].addItem("$s4");
        reg[i].addItem("$s5");
        reg[i].addItem("$s6");
        reg[i].addItem("$s7");
        reg[i].addItem("$t8");
        reg[i].addItem("$t9");
        reg[i].addItem("$k0");
        reg[i].addItem("$k1");
        reg[i].addItem("$gp");
        reg[i].addItem("$sp");
        reg[i].addItem("$fp");
        reg[i].addItem("$ra");
        reg[i].setBounds(200+i*100, 200, 100, 20);
        reg[i].setSelectedItem(null);
        this.add(reg[i]);
        
        }
          
    }
    public String getOperation(){
            return this.operation;
        }
    public String getregsrc(){
            return this.regsrc;
        }
    public String getregtarget(){
            return this.regtarget;
        }
    public String getregdst(){
            return this.regdst;
        }
    public int getOffset(){
            return this.number;
        }
    public static void main(String[] args) {
       GuiM m =new GuiM();
       m.setVisible(true);
    }
    
}
