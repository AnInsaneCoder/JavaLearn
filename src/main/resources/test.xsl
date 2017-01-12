<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/person">
        <html>
            <head>
                <title>Test XSLT</title>
            </head>
            <body>
                <h3>Hello <xsl:value-of select="name"/>!</h3>
                <div>You are <xsl:value-of select="age"/> years old and your favorite sport is <xsl:value-of select="hobby/sport"/></div>
                <div>Your favorite football stars are as follows:</div>
                <ul>
                    <xsl:for-each select="favorite-stars/star">
                        <li><xsl:value-of select="name"/>-<xsl:value-of select="age"/>-<xsl:value-of select="nationality"/></li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>