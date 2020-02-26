<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <head>
  <style>
  h1 {
	color: black;
  }
  </style>
  </head>
  <body>
  <h1 style="color:blue">CodeMate Report</h1>
  
  
  <xsl:for-each select="Report/Files/File">
	<h1 style="color:red"><xsl:value-of select="Name"/></h1>
	<h2 style="color:green">File Metrics:</h2>
	<xsl:for-each select="Metrics/Metric">
		<b>Metric: </b> <xsl:value-of select="Name"/><br/>
		<b>-Value: </b> <xsl:value-of select="Value"/><br/>
		<xsl:if test="Recommendation">
			<b>--Recommendation: </b> <xsl:value-of select="Recommendation"/><br/>
		</xsl:if>
	</xsl:for-each>
  <h2 style="color:green">Type/Method metrics:</h2>
  <xsl:for-each select="Types/Type">	
	<h2 style="color:DarkOrange"><xsl:value-of select="TypeType"/>:</h2>
  	<h3 ><xsl:value-of select="TypeName"/></h3>
  	<xsl:for-each select="Metrics/Metric">
		<b>Metric: </b> <xsl:value-of select="Name"/><br/>
		<b>-Value: </b> <xsl:value-of select="Value"/><br/>
		<xsl:if test="Recommendation">
			<b>--Recommendation: </b> <xsl:value-of select="Recommendation"/><br/>
		</xsl:if>
	</xsl:for-each>
  	
	<h3 style="color:Orange">Methods:</h3>
	  <xsl:for-each select="Methods/Method">		
			<h4><xsl:value-of select="MethodName"/></h4>
			<xsl:for-each select="Metrics/Metric">
				<b>Metric: </b> <xsl:value-of select="Name"/><br/>
				<b>-Value: </b> <xsl:value-of select="Value"/><br/>
				<xsl:if test="Recommendation">
					<b>--Recommendation: </b> <xsl:value-of select="Recommendation"/><br/>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
	  </xsl:for-each>
    </xsl:for-each>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>