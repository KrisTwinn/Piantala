# Generated by Django 3.1.4 on 2020-12-11 14:00

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('piantala', '0009_auto_20201211_1344'),
    ]

    operations = [
        migrations.DeleteModel(
            name='UserProfile',
        ),
        migrations.AddField(
            model_name='farmer',
            name='image',
            field=models.ImageField(default='', upload_to='avatar'),
        ),
        migrations.AlterField(
            model_name='genre',
            name='name',
            field=models.CharField(help_text='Inserisci genere prodotto!', max_length=25),
        ),
    ]