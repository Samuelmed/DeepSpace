/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;
import View.View;
import controller.Controller;
import java.util.ArrayList;
import deepspace.GameUniverseToUI;
//prueba
import deepspace.ShieldToUI;
import deepspace.WeaponToUI;
import deepspace.LootToUI;
import deepspace.NumericDamageToUI;
import deepspace.HangarToUI;
import deepspace.SpecificDamageToUI;
import deepspace.EnemyToUI;
import deepspace.GameState;
import deepspace.SpaceStationToUI;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel
 */
public class MainView extends javax.swing.JFrame implements View{
    
     static Controller controller;
     private String appName = "Deepspace Laumel 1.0";
     private SpaceStationView ssView;
     private EnemyStarShipView essView;
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
       
        ssView = new SpaceStationView();
        spacestationinfo.add(ssView);
 
        essView = new EnemyStarShipView();
        enemyinfo.add(essView);
        
        setTitle(appName);
        repaint();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                controller.finish(0);
            }
        });
        
        setLocationRelativeTo(null);
    }
    
    public ArrayList<String> getNames(){
        Names n = new Names(this);
        return n.getNames();
    }
    
    public void acceptLost(){
        JOptionPane.showMessageDialog(this, "Has PERDIDO el combate.\n¡CUMPLE TU CASTIGO!","Deep Space 1.0", JOptionPane.INFORMATION_MESSAGE);
    }
    public void acceptWin(){
        JOptionPane.showMessageDialog(this, "Has GANADO el combate.\n¡DISFRUTA DE TU BOTÍN!","Deep Space 1.0", JOptionPane.INFORMATION_MESSAGE);
    }
    public void acceptEscape(){
        JOptionPane.showMessageDialog(this, "Has  logrado escapar.\n¡¡¡¡ERES UN PAVO ESPACIAL!!!!","Deep Space 1.0", JOptionPane.INFORMATION_MESSAGE);
    }
    public void acceptConvert(){
        JOptionPane.showMessageDialog(this, "Has GANADO el combate.\n¡HAS CAMBIADO EL TIPO DE ESTACION ESPACIAL!","Deep Space 1.0", JOptionPane.INFORMATION_MESSAGE);
    }
    public void acceptFinalWin(){
        JOptionPane.showMessageDialog(this, "Has GANADO la partida.\n ¡ERES UN VERDADERO GUARDIÁN DE LA GALAXIA!","Deep Space 1.0", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     *
     */

    @Override
    public void updateView(){
        
        SpaceStationToUI p = controller.getUIversion().getCurrentStation();
        ssView.setSpaceStation(p);

//
        
       
      EnemyToUI e = controller.getUIversion().getCurrentEnemy();
      essView.setEnemy(e);
      
      //Solo vemos al enemigo si ya hemos combatido.

      essView.setVisible(controller.getState()==GameState.AFTERCOMBAT);
      
      jbCombat.setEnabled(controller.getState()==GameState.BEFORECOMBAT||controller.getState()==GameState.INIT);
      jbNext.setEnabled(controller.canIGoOn());
      ssView.ocultarDamage();
      
//      ssView.updateView();
//      ssView.updateView();
//        enemyinfo
//        ShieldToUI escudoprueba = controller.dameUnEscudoPrueba();
//        ShieldBoosterView vistaescudoprueba = new ShieldBoosterView();
//        vistaescudoprueba.setShieldBooster(escudoprueba);
//        panelprueba.add(vistaescudoprueba);

//        EnemyToUI e =controller.dameUnEnemigoPrueba();
//        EnemyStarShipView ev = new EnemyStarShipView();
//        ev.setEnemy(e);
//        enemyinfo.add(ev);
//        

//      SpaceStationToUI np =controller.dameUnaEstacionPrueba();
//        SpaceStationView nd = new SpaceStationView();
//        nd.setSpaceStation(np);
//        spacestationinfo.add(nd);

//        WeaponToUI ap = controller.dameUnArmaPrueba();
//        WeaponView vap = new WeaponView();
//        vap.setWeapon(ap);
//        panelprueba2.add(vap);

//        HangarToUI hp = controller.dameUnHangarPrueba();
//        HangarView hview = new HangarView();
//        hview.setHangar(hp);
//        panelprueba2.add(hview);
        
//        LootToUI lp = controller.dameUnBotinPrueba();
//        LootView vlp = new LootView();
//        vlp.setLoot(lp);
//        panelprueba3.add(vlp);
        
        repaint();
        revalidate(); 
        
    }
    
    public void setController(Controller c){
        controller=c;
    }
    
    @Override
    public void showView(){
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spacestationinfo = new javax.swing.JPanel();
        enemyinfo = new javax.swing.JPanel();
        jbCombat = new javax.swing.JButton();
        jbNext = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbCombat.setText("¡COMBATIR!");
        jbCombat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCombatActionPerformed(evt);
            }
        });

        jbNext.setText("Siguiente");
        jbNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNextActionPerformed(evt);
            }
        });

        jbExit.setText("Salir");
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spacestationinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enemyinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbNext, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCombat, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enemyinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spacestationinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCombat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCombatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCombatActionPerformed
        // TODO add your handling code here:
        controller.combat();
    }//GEN-LAST:event_jbCombatActionPerformed

    private void jbNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNextActionPerformed
        // TODO add your handling code here:
        controller.nextTurn();
    }//GEN-LAST:event_jbNextActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        // TODO add your handling code here:
        controller.finish(0);
    }//GEN-LAST:event_jbExitActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel enemyinfo;
    private javax.swing.JButton jbCombat;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbNext;
    private javax.swing.JPanel spacestationinfo;
    // End of variables declaration//GEN-END:variables
}