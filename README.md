# PriceParserBatch

Java app for parsing product prices from e-commerce website using Spring Batch.

Batch flow ;

Read previously saved product categories from database.

Use Url's from these categories to get to website.

Use JSoup library for HTML parsing.

Get product data from database , create product in database if not found.

Get the last price data of the product from database and compare it to current price.

Skip if prices are the same or there is no last price on database.

Save all new price data to database.

Create a HTML data table for products whose price decreased at least by %15.

Send the HTML data table to email address using SendGrid Email API.

Currently deployed on Azure as a WebJob working in interval.
