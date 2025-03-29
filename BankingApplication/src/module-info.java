module banking {
    requires java.desktop;   // For AWT, Swing, JFrame
    requires java.sql;       // For database connection
    requires jcalendar;      // For JDateChooser
    requires java.base; 
    opens banking;  // Add the missing module explicitly
}
